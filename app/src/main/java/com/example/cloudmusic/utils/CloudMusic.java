package com.example.cloudmusic.utils;

/**
 * 一些配置信息
 */
public class CloudMusic {
    public static final String baseUrl="https://netease-cloud-music-api-beta-inky-62.vercel.app/";
    public static final String SUCCEED="succeed";
    public static final String FAILURE="failure";
    public static final int Loop=0;
    public static final int Single_Loop =1;
    public static final int Random=2;

    public static boolean isGettingSongUrl = false;//防止操作过快
    public static boolean isStartPlayerActivity = false;//防止二次启动PlayerActivity
    public static boolean isStartMusicListDialog = false;//防止二次启动MusicListDialog

}
