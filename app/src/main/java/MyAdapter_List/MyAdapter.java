package MyAdapter_List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by ZhangTAO on 2017/12/17.
 */

public class MyAdapter extends FragmentStatePagerAdapter{
    private List<Fragment> alist;
    public MyAdapter(FragmentManager supportFragmentManager, List<Fragment> fraglist) {
        super(supportFragmentManager);
        this.alist = fraglist;
    }
    @Override
    public Fragment getItem(int position) {
        return alist.get(position);
    }
    @Override
    public int getCount() {
        return alist.size();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        super.destroyItem(container, position, object);
    }
}
