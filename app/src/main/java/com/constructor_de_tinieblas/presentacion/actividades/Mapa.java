package com.constructor_de_tinieblas.presentacion.actividades;

import android.os.Bundle;
import android.util.Log;

import androidx.fragment.app.FragmentActivity;

import com.constructor_de_tinieblas.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Mapa extends FragmentActivity implements OnMapReadyCallback {
    
    private GoogleMap gMap;
    private Double latitud;
    private Double longitud;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mapa);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        
        int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(getApplicationContext());
        
        if(status == ConnectionResult.SUCCESS) {
            Log.i("ConexionMapa", "Éxito al conectarse a Google Maps");
        } else {
            Log.w("ConexionMapa", "No se ha podido conectar a Google Maps");
        }
        
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        
        latitud = getIntent().getExtras().getDouble(String.valueOf(R.string.latitud));
        longitud = getIntent().getExtras().getDouble(String.valueOf(R.string.longitud));
        
        Log.d("Mapa", "latitud >>> " + latitud.toString());
        Log.d("Mapa", "longitud >>> " + longitud.toString());
    }
    
    
    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        gMap = googleMap;
    
        UiSettings settings = gMap.getUiSettings();
        settings.setZoomControlsEnabled(true);
        
        LatLng localizacion = new LatLng(latitud, longitud);
        gMap.addMarker(new MarkerOptions().position(localizacion).title("El hogar del personaje").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)));
        
        float zoomlevel = 16;
        
        gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(localizacion, zoomlevel));
    }
}
