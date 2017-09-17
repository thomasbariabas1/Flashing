package gr.aegean.com.flashing;

import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import gr.aegean.com.flashing.Model.MorseCode;

public class FlashLightActivity extends AppCompatActivity {



    FragmentStatePagerAdapter adapterViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_light);


        ViewPager vpPager = (ViewPager) findViewById(R.id.vpPager);
        adapterViewPager = new gr.aegean.com.flashing.Adapters.FragmentStatePagerAdapter(getSupportFragmentManager());

        vpPager.setAdapter(adapterViewPager);


    }


}
