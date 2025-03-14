package com.example.cloudmusic;

import android.app.Application;
import android.content.Context;
import androidx.annotation.NonNull;
import com.example.cloudmusic.entity.Artist;
import org.litepal.LitePal;
import java.util.HashSet;
import java.util.Set;

/**
 * 一些配置信息
 */
public class CloudMusic extends Application {
    //public static final String baseUrl="https://netease-cloud-music-api-beta-inky-62.vercel.app/";
    //public static final String baseUrl="http://cloud-music.pl-fe.cn/";
    public static final String baseUrl="https://cloudmusic.wilinz.com/";
    public static final String SUCCEED="succeed";
    public static final String FAILURE="failure";
    public static final String LOGIN_TYPE="nickname_repeat";//从哪启动的登陆面
    public static final String LOGIN_INSIDE="LOGIN_INSIDE";//从哪启动的登陆面
    public static final String LOGIN_START="LOGIN_START";//从哪启动的登陆面
    public static final int Loop=0;
    public static final int Single_Loop =1;
    public static final int Random=2;

    public static boolean isGettingSongUrl = false;//防止操作过快
    public static boolean isStartPlayerActivity = false;//防止二次启动PlayerActivity
    public static boolean isStartMusicListDialog = false;//防止二次启动MusicListDialog
    public static boolean isReset = false;//是否正在释放MediaPlayer
    public static boolean isLiking = false;//是否正在喜欢/取消喜欢
    public static boolean isLogin = true;//是否已登陆
    public static boolean isSongFragmentEventBusRegister = false;//是否打开PlayerActivity

    public static Set<String> likeSongIdSet =new HashSet<>();
    public static Set<String> likeArtistIdSet =new HashSet<>();
    public static Set<Artist> likeArtistSet =new HashSet<>();

    public static String phone;
    public static String userId="0";
    public static String nickname="立即登陆";
    public static String level="1";
    public static int lrcOffset=0;//歌词偏移
    public static int requestUrlTime=0;//网络重试次数
    public static String avatarUrl;

    private static Application context;

    @NonNull
    public static Context getContext() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        LitePal.initialize(this);
    }

}
