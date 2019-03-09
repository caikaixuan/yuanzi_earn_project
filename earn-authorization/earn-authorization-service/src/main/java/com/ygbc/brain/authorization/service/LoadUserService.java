package com.ygbc.brain.authorization.service;

import com.ygbc.brain.authorization.api.Constants.AuthorConstants;
import com.ygbc.brain.authorization.api.dto.LoadUserRespDTO;
import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.common.dal.data.*;
import com.ygbc.brain.business.common.module.Platform;
import com.ygbc.brain.business.common.module.SysModule;
import com.ygbc.brain.business.common.service.base.BaseExecutableService;
import com.ygbc.brain.common.model.*;
import com.ygbc.brain.common.session.RedisSessionManager;
import com.ygbc.brain.common.utils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.session.MapSession;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class LoadUserService extends BaseExecutableService<Req, Resp<LoadUserRespDTO>> {

    @Autowired
    private RedisSessionManager redisSessionManager;

    @Override
    public Resp<LoadUserRespDTO> execute(Req req) throws Exception {
        Resp<LoadUserRespDTO> resp = new Resp<>();
        LoadUserRespDTO loadUserRespDTO = new LoadUserRespDTO();
        SysModule sysModule = new SysModule();
        MapSession mapSession = this.context.getSession();
        //加载用户
        UserData userData = Platform.sdbRead(UserData.class, req.getLoginName());
        if (userData == null) {
            return Resp.build(LoadUserRespDTO.class, AuthorConstants.INVALID_USER_OR_PASSWORD_ERROR_CODE, AuthorConstants.INVALID_USER_OR_PASSWORD_ERROR_MSG);
        }
        sysModule.setUserData(userData);
        loadUserRespDTO.setUserModel(BeanUtils.copyAs(userData, UserModel.class));
        //加载角色
        RoleData roleData = Platform.dbRead("selectByLoginName", RoleData.class, req.getLoginName());
        if (roleData != null) {
            sysModule.setRoleData(roleData);
            loadUserRespDTO.setRoleModel(BeanUtils.copyAs(roleData, RoleModel.class));
        }
        //加载菜单
        if (roleData != null) {
            List<MenuData> menuDataList = Platform.dbReadSet("selectByRoleId", MenuData.class, roleData.getId());
            if (!CollectionUtils.isEmpty(menuDataList)) {
                loadUserRespDTO.setMenuModels(this.loadMenu(menuDataList));
            }
        }
        //加载PTY
        PartyData partyData = null;
        if (StringUtils.isNotBlank(userData.getPartyCode())) {
            partyData = Platform.sdbRead(PartyData.class, userData.getPartyCode());
            if (partyData != null) {
                sysModule.setPartyData(partyData);
                loadUserRespDTO.setPartyModel(BeanUtils.copyAs(partyData, PartyModel.class));
            }
        }
        //加载BCH
        if (partyData != null && StringUtils.isNotBlank(partyData.getPartyCode())) {
            BranchData branchData = Platform.dbRead("selectByPartyCode", BranchData.class, partyData.getPartyCode());
            if (branchData != null) {
                sysModule.setBranchData(branchData);
                loadUserRespDTO.setBranchModel(BeanUtils.copyAs(branchData, BranchModel.class));
            }
        }
        //加载ETY
        EntityData entityData = null;
        if (StringUtils.isNotBlank(userData.getEntityCode())) {
            entityData = Platform.sdbRead(EntityData.class, userData.getEntityCode());
            if (entityData != null) {
                sysModule.setEntityData(entityData);
                loadUserRespDTO.setEntityModel(BeanUtils.copyAs(entityData, EntityModel.class));
            }
        }
        //加载ETG
        if (entityData != null && StringUtils.isNotBlank(entityData.getGroupCode())) {
            EntityGroupData entityGroupData = Platform.sdbRead(EntityGroupData.class, entityData.getGroupCode());
            if (entityGroupData != null) {
                sysModule.setEntityGroupData(entityGroupData);
            }
        }
        mapSession.setAttribute(SysModule.NAME, sysModule);
        redisSessionManager.doUpdate(req.getLoginName(), mapSession);
        resp.setData(loadUserRespDTO);
        return resp;
    }

    private List<MenuModel> loadMenu(List<MenuData> menuDataList) throws Exception {
        List<MenuModel> menuModelList = new ArrayList<>();
        for (int i = 0; i < menuDataList.size(); i++) {
            MenuData menuData = menuDataList.get(i);
            if (menuData != null && menuData.getPid() == null) {
                menuModelList.add(BeanUtils.copyAs(menuData, MenuModel.class));
                menuDataList.remove(i);
                i--;
            }
        }
        for (MenuModel menuModel : menuModelList) {
            menuModel.setChildMenuList(getChildMenu(menuModel.getId(), menuDataList));
        }
        if (!CollectionUtils.isEmpty(menuModelList)) {
            Collections.sort(menuModelList, new Comparator<MenuModel>() {
                public int compare(MenuModel model1, MenuModel model2) {
                    return model1.getShowOrder().compareTo(model2.getShowOrder());
                }
            });
        }
        return menuModelList;
    }

    private List<MenuModel> getChildMenu(Long id, List<MenuData> menuDataList) throws Exception {
        // 子菜单
        List<MenuModel> childList = new ArrayList<>();
        for (int i = 0; i < menuDataList.size(); i++) {
            MenuData menuData = menuDataList.get(i);
            // 遍历所有节点，将父菜单id与传过来的id比较
            if (menuData != null && menuData.getPid() != null) {
                if (menuData.getPid().equals(id)) {
                    MenuModel menuModel = BeanUtils.copyAs(menuData, MenuModel.class);
                    childList.add(menuModel);
                    menuDataList.remove(i);
                    i--;
                    menuModel.setChildMenuList(getChildMenu(menuModel.getId(), menuDataList));
                }
            }
        }
        if (!CollectionUtils.isEmpty(childList)) {
            Collections.sort(childList, new Comparator<MenuModel>() {
                public int compare(MenuModel model1, MenuModel model2) {
                    return model1.getShowOrder().compareTo(model2.getShowOrder());
                }
            });
        }
        return (childList.size() > 0 ? childList : null);
    }
}
