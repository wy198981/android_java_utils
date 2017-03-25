package com.example.testpopuwindow.spinnerList;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.testpopuwindow.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-03-25.
 */
public class SimplePopHelper implements View.OnClickListener
{
    /**
     * �򵥵�popu,����ֻ����ʾһ���б�����
     */
    private final ImageButton imageButton;
    private final CustemSpinerAdapter mAdapter;
    private final List<String> nameList = new ArrayList<String>();
    private final SpinerPopWindow spinerPopWindow;
    private final TextView textView;
    private Activity mActivity;

    public SimplePopHelper(Activity activity)
    {
        this.mActivity = activity;
        mAdapter = new CustemSpinerAdapter(activity);
        mAdapter.refreshData(nameList, 0);
        spinerPopWindow = new SpinerPopWindow(activity);
        spinerPopWindow.setAdatper(mAdapter);

        imageButton = (ImageButton) activity.findViewById(R.id.bt_Stationdropdown);
        imageButton.setOnClickListener(this);

        textView = (TextView) activity.findViewById(R.id.tv_Stationvalue);
        spinerPopWindow.setItemListener(new AbstractSpinerAdapter.IOnItemSelectListener()
        {
            @Override
            public void onItemClick(int pos)
            {
                String listDataByIndex = getListDataByIndex(pos);
                onItemClickCB(pos, listDataByIndex);
                textView.setText(listDataByIndex);
            }
        });
    }

    public void onItemClickCB(int position, String itemText)
    {

    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.bt_Stationdropdown:
                spinerPopWindow.setWidth(textView.getWidth());
                spinerPopWindow.showAsDropDown(textView);
                break;
        }
    }

    class CustemSpinerAdapter extends AbstractSpinerAdapter<String>
    {
        public CustemSpinerAdapter(Context context)
        {
            super(context);
        }
    }


    private String getListDataByIndex(int index)
    {
        if (index >= 0 && index <= nameList.size())
        {
            return nameList.get(index);
        }
        return null;
    }

    /**
     * ˢ�����ݣ���ȫ��ʼ��ʾ����
     *
     * @param list
     * @param index
     */
    public void refreshData(List<String> list, int index)
    {
        nameList.clear();
        nameList.addAll(list);
        mAdapter.refreshData(nameList, index);
        textView.setText(getListDataByIndex(index));
    }

    /**
     * ������ݣ�����һ������
     *
     * @param item
     * @param index
     */
    public void addEachData(String item, int index)
    {
        nameList.add(0, item);
        mAdapter.refreshData(nameList, index);
        textView.setText(getListDataByIndex(index));
    }

    /**
     * ������ݣ����������б�
     *
     * @param list
     * @param index
     */
    public void addDataList(List<String> list, int index)
    {
        mAdapter.refreshData(nameList, index);
        textView.setText(getListDataByIndex(index));
    }
}
