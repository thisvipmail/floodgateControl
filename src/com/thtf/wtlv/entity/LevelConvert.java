package com.thtf.wtlv.entity;

public enum LevelConvert {
	LevelA("��", 'A'), LevelB("��", 'B'), LevelC("��", 'C'), LevelD("��", 'D'), LevelE("��", 'E');  
    // ��Ա����  
    private String name;  
    private int code;  
    // ���췽��  
    private LevelConvert(String name, int code) {  
        this.name = name;  
        this.code = code;  
    }  
    // ��ͨ����  
    public static String getName(int index) {  
        for (LevelConvert c : LevelConvert.values()) {  
            if (c.getCode() == index) {  
                return c.name;  
            }  
        }  
        return null;  
    }  
    // get set ����  
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
