package com.thtf.wtlv.entity;

public enum LevelConvert {
	LevelA("Ⅰ", 'A'), LevelB("Ⅱ", 'B'), LevelC("Ⅲ", 'C'), LevelD("Ⅴ", 'D'), LevelE("Ⅳ", 'E');  
    // 成员变量  
    private String name;  
    private int code;  
    // 构造方法  
    private LevelConvert(String name, int code) {  
        this.name = name;  
        this.code = code;  
    }  
    // 普通方法  
    public static String getName(int index) {  
        for (LevelConvert c : LevelConvert.values()) {  
            if (c.getCode() == index) {  
                return c.name;  
            }  
        }  
        return null;  
    }  
    // get set 方法  
    public String getName() {  
        return name;  
    }  
    public void setName(String name) {  
        this.name = name;  
    }
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}  
    
    
}
