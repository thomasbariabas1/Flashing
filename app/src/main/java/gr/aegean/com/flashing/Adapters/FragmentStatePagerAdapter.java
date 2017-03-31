package gr.aegean.com.flashing.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import gr.aegean.com.flashing.MorseFlashLightFragment;
import gr.aegean.com.flashing.SimpleFlashLightFragment;

/**
 * Created by phantomas on 3/30/2017.
 */

public class FragmentStatePagerAdapter extends android.support.v4.app.FragmentStatePagerAdapter {
    private static int NUM_ITEMS = 2;

    public FragmentStatePagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return SimpleFlashLightFragment.newInstance();
            case 1:
                return MorseFlashLightFragment.newInstance();

            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return  NUM_ITEMS;
    }
    @Override
    public CharSequence getPageTitle(int position) {

        if(position==0)
            return "Simple Flash";
        return "Morse Flash";
    }
}
