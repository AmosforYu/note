package com.yyb.learn.jbasics.basic.annotation;

import org.apache.commons.lang.StringUtils;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * @author Yamos
 * @description Apple
 * @date 2020/12/16 0016 14:29
 */
public class Apple {
    @FruitName("Apple")
    private String appleName;

    @FruitColor(fruitColor = FruitColor.Color.RED)
    private String appleColor;

    @FruitProvider(id = 1, name = "陕西红富士集团", address = "陕西省西安市延安路89号红富士大厦")
    private String appleProvider;

    public Apple(String appleName, String appleColor, String appleProvider) {
        Class<? extends Apple> appleClass = this.getClass();

        try {
            if (StringUtils.isNotEmpty(appleName)) {
                Field appleName1 = appleClass.getDeclaredField("appleName");
                FruitName fruitName = appleName1.getAnnotation(FruitName.class);

                //获取 fruitName 这个代理实例所持有的 InvocationHandler
                InvocationHandler invocationHandler = Proxy.getInvocationHandler(fruitName);
                // 获取 AnnotationInvocationHandler 的 memberValues 字段
                Field memberValues = invocationHandler.getClass().getDeclaredField("memberValues");
                // 因为这个字段是 private final 修饰，所以要打开权限
                memberValues.setAccessible(true);
                // 获取 memberValues
                Map memberMap = (Map) memberValues.get(invocationHandler);
                // 修改 注解的value 属性值
                memberMap.put("value", appleName);
            }

            if (StringUtils.isNotEmpty(appleColor)) {
                Field appleColor1 = appleClass.getDeclaredField("appleColor");
                FruitColor fruitColor = appleColor1.getAnnotation(FruitColor.class);

                InvocationHandler invocationHandler = Proxy.getInvocationHandler(fruitColor);
                Field memberValues = invocationHandler.getClass().getDeclaredField("memberValues");
                memberValues.setAccessible(true);
                Map memberMap = (Map) memberValues.get(invocationHandler);
                memberMap.put("fruitColor", FruitColor.Color.BLUE);
            }

            if (StringUtils.isNotEmpty(appleProvider)) {
                Field appleProvider1 = appleClass.getDeclaredField("appleProvider");
                FruitProvider fruitProvider = appleProvider1.getAnnotation(FruitProvider.class);

                InvocationHandler invocationHandler = Proxy.getInvocationHandler(fruitProvider);
                Field memberValues = invocationHandler.getClass().getDeclaredField("memberValues");
                memberValues.setAccessible(true);
                Map memberMap = (Map) memberValues.get(invocationHandler);
                String[] appleProviderArr = appleProvider.split(",");
                memberMap.put("id", Integer.valueOf(appleProviderArr[0]));
                memberMap.put("name", appleProviderArr[1]);
                memberMap.put("address", appleProviderArr[2]);
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void setAppleColor(String appleColor) {
        this.appleColor = appleColor;
    }

    public String getAppleColor() {
        return appleColor;
    }

    public void setAppleName(String appleName) {
        this.appleName = appleName;
    }

    public String getAppleName() {
        return appleName;
    }

    public void setAppleProvider(String appleProvider) {
        this.appleProvider = appleProvider;
    }

    public String getAppleProvider() {
        return appleProvider;
    }

    public void displayName() {
        System.out.println("水果的名字是：苹果");
    }
}
