package com.ygbc.brain.authorization.api.dto;

import com.ygbc.brain.base.dto.BaseDTO;
import com.ygbc.brain.common.model.*;

import java.util.List;

public class LoadUserRespDTO extends BaseDTO {

    private UserModel userModel;

    private RoleModel roleModel;

    private List<MenuModel> menuModels;

    private PartyModel partyModel;

    private BranchModel branchModel;

    private EntityModel entityModel;

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }

    public RoleModel getRoleModel() {
        return roleModel;
    }

    public void setRoleModel(RoleModel roleModel) {
        this.roleModel = roleModel;
    }

    public List<MenuModel> getMenuModels() {
        return menuModels;
    }

    public void setMenuModels(List<MenuModel> menuModels) {
        this.menuModels = menuModels;
    }

    public PartyModel getPartyModel() {
        return partyModel;
    }

    public void setPartyModel(PartyModel partyModel) {
        this.partyModel = partyModel;
    }

    public BranchModel getBranchModel() {
        return branchModel;
    }

    public void setBranchModel(BranchModel branchModel) {
        this.branchModel = branchModel;
    }

    public EntityModel getEntityModel() {
        return entityModel;
    }

    public void setEntityModel(EntityModel entityModel) {
        this.entityModel = entityModel;
    }
}
