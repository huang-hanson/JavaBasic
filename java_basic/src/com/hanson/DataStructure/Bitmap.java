package com.hanson.DataStructure;

/**
 * @author 黄忠
 */
/*以bit为存储单位的数据结构，对于给定的第i位。1表示true，0表示false*/
public class Bitmap {
    private byte[] bytes;
    //length为位图的长度，实际可操作的下表为[0,length)
    private int length;
}
