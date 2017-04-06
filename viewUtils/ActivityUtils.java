package com.example.administrator.myparkingos.util;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by Administrator on 2017-03-06.
 */
public class ActivityUtils
{
    public static void addFragmentToActivity(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, int frameId)
    {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(frameId, fragment);
        transaction.commit();
    }
	
	// 可以最大程度的简化代码，一行代码可以简化出几个小功能；
	public static final void invoke(Activity activity, Class<?> clazz)
    {
        Intent intent = new Intent(activity, clazz);
        activity.startActivity(intent);
    }

    public static final void invokeWithArgs(Activity activity, Class<?> clazz, Bundle bundle)
    {
        Intent intent = new Intent(activity, clazz);
        intent.putExtra("bundle", bundle);
        activity.startActivity(intent);
    }
	
}
