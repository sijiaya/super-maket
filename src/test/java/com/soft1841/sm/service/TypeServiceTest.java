package com.soft1841.sm.service;

import com.soft1841.sm.entity.Type;
import com.soft1841.sm.utils.ServiceFactory;
import org.junit.Test;

import javax.annotation.processing.SupportedAnnotationTypes;
import javax.xml.ws.soap.Addressing;
import java.util.List;

import static org.junit.Assert.*;

public class TypeServiceTest {
    private TypeService typeService = ServiceFactory.getTypeServiceInstance();

    @Test
    public void selectAlltypes() {
        //返回一个List型的typeList，调用TypeService中的查询类别方法
        List<Type> typeList = typeService.selectAllType();
        typeList.forEach(type -> System.out.println(type));
    }

    @Test
    public void deleteType() {
        typeService.deleteType(10);
    }

    @Test
    public void addType(){
        Type type = new Type();
        type.setName("测试新类别");
        type.setCover("https://");
        typeService.addType(type);
    }
}