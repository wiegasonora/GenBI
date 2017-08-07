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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

public class Komentar extends AppCompatActivity {
    private ListView mDrawerList;
    private ArrayAdapter<String> mAdapter;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    private String mActivityTitle;
    private Intent intentDrawer;

    private LinearLayout lineKomentarMahasiswa;
    private LinearLayout lineKomentarMasyarakat;
    private LinearLayout lineDescMahasiswa;
    private LinearLayout lineDescMasyarakat;
    private boolean isClickedMahasiswa = false;
    private boolean isClickedMasyarakat = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_komentar);

        System.out.println("DEBUG masuk A");

        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        mActivityTitle = getTitle().toString();

        addDrawerItems();

        System.out.println("DEBUG masuk B");

        setupDrawer();

        System.out.println("DEBUG masuk C");

        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        intentDrawer = new Intent(Komentar.this, Beranda.class);
                        break;
                    case 1:
                        intentDrawer = new Intent(Komentar.this, SiapaKami.class);
                        break;
                    case 2:
                        intentDrawer = new Intent(Komentar.this, AktivitasKami.class);
                        break;
                    case 3:
                        intentDrawer = new Intent(Komentar.this, BeritaKami.class);
                        break;
                    case 4:
                        intentDrawer = new Intent(Komentar.this, Galeri.class);
                        break;
                    case 5:
                        intentDrawer = new Intent(Komentar.this, Komentar.class);
                        break;
                    case 6:
                        intentDrawer = new Intent(Komentar.this, Beasiswa.class);
                        break;
                    case 7:
                        intentDrawer = new Intent(Komentar.this, Login.class);
                        break;
                    default:
                        break;
                }
                startActivity(intentDrawer);
            }
        });


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);


        System.out.println("DEBUG masuk D");

        lineKomentarMahasiswa = (LinearLayout) findViewById(R.id.line_komentarmahasiswa);
        lineKomentarMasyarakat = (LinearLayout) findViewById(R.id.line_komentarmasyarakat);

        lineDescMahasiswa = (LinearLayout) findViewById(R.id.line_komentarmahasiswa_text);
        lineDescMasyarakat = (LinearLayout) findViewById(R.id.line_komentarmasyarakat_text);

        lineDescMahasiswa.setVisibility(View.GONE);
        lineDescMasyarakat.setVisibility(View.GONE);


        System.out.println("DEBUG masuk E");

        lineKomentarMahasiswa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView down = (ImageView) findViewById(R.id.down_arrow_komentarmahasiswa);
                if (isClickedMahasiswa){
                    down.setImageResource(R.drawable.down_arrow);
                    lineKomentarMahasiswa.setBackgroundResource(R.drawable.rounded_button_siapa_kami);
                    lineDescMahasiswa.setVisibility(View.GONE);
                    isClickedMahasiswa = false;
                } else {
                    down.setImageResource(R.drawable.up_arrow);
                    lineKomentarMahasiswa.setBackgroundResource(R.drawable.rounded_button_siapa_kami_clicked);
                    lineDescMahasiswa.setVisibility(View.VISIBLE);
                    isClickedMahasiswa = true;
                }
            }
        });

        lineKomentarMasyarakat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView down = (ImageView) findViewById(R.id.down_arrow_komentarmasyarakat);
                if (isClickedMasyarakat){
                    down.setImageResource(R.drawable.down_arrow);
                    lineKomentarMasyarakat.setBackgroundResource(R.drawable.rounded_button_siapa_kami);
                    lineDescMasyarakat.setVisibility(View.GONE);
                    isClickedMasyarakat = false;
                } else {
                    down.setImageResource(R.drawable.up_arrow);
                    lineKomentarMasyarakat.setBackgroundResource(R.drawable.rounded_button_siapa_kami_clicked);
                    lineDescMasyarakat.setVisibility(View.VISIBLE);
                    isClickedMasyarakat = true;
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
