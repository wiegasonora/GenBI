package bankindonesia.genbi;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

public class SiapaKami extends AppCompatActivity {
    private ListView mDrawerList;
    private ArrayAdapter<String> mAdapter;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    private String mActivityTitle;
    private Intent intentDrawer;

    private LinearLayout lineGenBaruIndo;
    private LinearLayout lineSambutanGubBI;
    private LinearLayout lineIkrar;
    private LinearLayout lineDesc;
    private LinearLayout lineSambutanDesc;
    private LinearLayout lineIkrarDesc;
    private boolean isClickedGenBI = false;
    private boolean isClickedGubBI = false;
    private boolean isClickedIkrar = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_siapa_kami);

        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        mActivityTitle = getTitle().toString();

        addDrawerItems();

        setupDrawer();

        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            switch (position){
                case 0:
                    intentDrawer = new Intent(SiapaKami.this, Beranda.class);
                    break;
                case 7:
                    intentDrawer = new Intent(SiapaKami.this, Login.class);
                    break;
                default:
                    break;
            }
            startActivity(intentDrawer);
            }
        });


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        lineGenBaruIndo = (LinearLayout) findViewById(R.id.line_generasibaruindonesia);
        lineSambutanGubBI = (LinearLayout) findViewById(R.id.line_sambutangubernurbi);
        lineIkrar = (LinearLayout) findViewById(R.id.line_ikrar_genbi);

        lineDesc = (LinearLayout) findViewById(R.id.line_generasibaruindonesia_text);
        lineSambutanDesc = (LinearLayout) findViewById(R.id.line_sambutangubernurbi_text);
        lineIkrarDesc = (LinearLayout) findViewById(R.id.line_ikrar_genbi_text);

        lineDesc.setVisibility(View.GONE);
        lineSambutanDesc.setVisibility(View.GONE);
        lineIkrarDesc.setVisibility(View.GONE);

        lineGenBaruIndo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView down = (ImageView) findViewById(R.id.down_arrow_generasibaruindo);
                if (isClickedGenBI){
                    down.setImageResource(R.drawable.down_arrow);
                    lineGenBaruIndo.setBackgroundResource(R.drawable.rounded_button_siapa_kami);
                    lineDesc.setVisibility(View.GONE);
                    isClickedGenBI = false;
                } else {
                    down.setImageResource(R.drawable.up_arrow);
                    lineGenBaruIndo.setBackgroundResource(R.drawable.rounded_button_siapa_kami_clicked);
                    lineDesc.setVisibility(View.VISIBLE);
                    isClickedGenBI = true;
                }
            }
        });

        lineSambutanGubBI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView down = (ImageView) findViewById(R.id.down_arrow_sambutangubernur);
                if (isClickedGubBI){
                    down.setImageResource(R.drawable.down_arrow);
                    lineSambutanGubBI.setBackgroundResource(R.drawable.rounded_button_siapa_kami);
                    lineSambutanDesc.setVisibility(View.GONE);
                    isClickedGubBI = false;
                } else {
                    down.setImageResource(R.drawable.up_arrow);
                    lineSambutanGubBI.setBackgroundResource(R.drawable.rounded_button_siapa_kami_clicked);
                    lineSambutanDesc.setVisibility(View.VISIBLE);
                    isClickedGubBI = true;
                }
            }
        });
        lineIkrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView down = (ImageView) findViewById(R.id.down_arrow_ikrar_genbi);
                if (isClickedIkrar){
                    down.setImageResource(R.drawable.down_arrow);
                    lineIkrar.setBackgroundResource(R.drawable.rounded_button_siapa_kami);
                    lineIkrarDesc.setVisibility(View.GONE);
                    isClickedIkrar = false;
                } else {
                    down.setImageResource(R.drawable.up_arrow);
                    lineIkrar.setBackgroundResource(R.drawable.rounded_button_siapa_kami_clicked);
                    lineIkrarDesc.setVisibility(View.VISIBLE);
                    isClickedIkrar = true;
                }
            }
        });

    }

    private void addDrawerItems() {
        mDrawerList = (ListView) findViewById(R.id.navList);
        String[] titleMenu = {"Beranda", "Siapa Kami", "Aktivitas Kami", "Berita Kami", "Galeri", "Komentar", "Beasiswa", "Login"};
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, titleMenu);
        mDrawerList.setAdapter(mAdapter);
    }

    private void setupDrawer() {
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                R.string.drawer_open, R.string.drawer_close) {

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
            }

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
            }
        };

        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        // Activate the navigation drawer toggle
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
