package com.easemob.ui.utils;

import android.content.Context;
import android.widget.ImageView;

import com.easemob.uidata.User;
import com.easemob.uidemo.R;
import com.squareup.picasso.Picasso;

public class UserUtils {
    /**
     * 根据username获取相应user，由于demo没有真实的用户数据，这里给的模拟的数据；
     * @param username
     * @return
     */
	// TODO, EMWidget
//    public static User getUserInfo(String username){
//        User user = DemoApplication.getInstance().getContactList().get(username);
//        if(user == null){
//            user = new User(username);
//        }
//            
//        if(user != null){
//            //demo没有这些数据，临时填充
//            user.setNick(username);
////            user.setAvatar("http://downloads.easemob.com/downloads/57.png");
//        }
//        return user;
//    }
    
    /**
     * 设置用户头像
     * @param username
     */
    public static void setUserAvatar(Context context, String username, ImageView imageView){
//        User user = getUserInfo(username);
        User user = null;
        if(user != null){
            Picasso.with(context).load(user.getAvatar()).placeholder(R.drawable.em_default_avatar).into(imageView);
        }else{
            Picasso.with(context).load(R.drawable.em_default_avatar).into(imageView);
        }
    }
    
}
