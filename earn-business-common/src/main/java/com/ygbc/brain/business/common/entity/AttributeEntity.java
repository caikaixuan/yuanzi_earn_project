package com.ygbc.brain.business.common.entity;

import com.ygbc.brain.business.common.dal.data.BaseData;

import java.util.HashMap;
import java.util.Map;

public class AttributeEntity <M extends AttributeEntity,T extends BaseData> extends BaseEntity<T>{

    private Map<String,Object> attrs = new HashMap<>();

    public AttributeEntity(){

    }

    public AttributeEntity(T data){
        super(data);
    }

    public M put(String key,Object value){
        attrs.put(key,value);
        return (M) this;
    }

    public M remove(String key){
        attrs.remove(key);
        return (M) this;
    }

    public M clearAttrs(){
        attrs.clear();
        return (M) this;
    }

    public <T> T getObject  (String key){
        Object value = attrs.get(key);
        if(value == null) {
            return null;
        }else{
            return (T) value;
        }
    }

    public long getLong(String key){
        return getLong(key,0L);
    }

    public long getLong(String key,long defaultValue){
        Object value = attrs.get(key);
        if(value == null){
            return defaultValue;
        }else{
            return (long)value;
        }
    }

    public boolean getBoolean(String key){
        return getBoolean(key,false);
    }

    public boolean getBoolean(String key,boolean defaultValue){
        Object value = attrs.get(key);
        if(value == null){
            return defaultValue;
        }else{
            return (boolean)value;
        }
    }

    public String getString(String key){
        return getString(key,"");
    }

    public String getString(String key,String defaultValue){
        Object value = attrs.get(key);
        if(value == null){
            return defaultValue;
        }else{
            return (String)value;
        }
    }

    public int getInt(String key){
        return getInt(key,0);
    }

    public int getInt(String key,int defaultValue){
        Object value = attrs.get(key);
        if(value == null){
            return defaultValue;
        }else{
            return (int)value;
        }
    }
}
