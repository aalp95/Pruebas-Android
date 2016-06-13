package angelapps.com.tarea2coursera;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextInputEditText textoFecha;
    Button botonFecha;
    int año, mes, dia;
    static final int DIALOG_ID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textoFecha = (TextInputEditText) findViewById(R.id.textoFecha);

        final Calendar calendario = Calendar.getInstance();
        año = calendario.get(Calendar.YEAR);
        mes = calendario.get(Calendar.MONTH);
        dia = calendario.get(Calendar.DAY_OF_MONTH);
        showDialogOnButtonCLick();


    }

    public void showDialogOnButtonCLick(){
        botonFecha = (Button)findViewById(R.id.botonFecha);

        botonFecha.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showDialog(DIALOG_ID);
                    }
                }
        );

    }

    protected Dialog onCreateDialog(int id){

        if (id == DIALOG_ID)
            return new DatePickerDialog(this, dpickerListener, año, mes, dia);

        return null;
    }

    private DatePickerDialog.OnDateSetListener dpickerListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            año = year;
            mes = monthOfYear;
            dia = dayOfMonth;
            mostrarFecha();
        }

    };

    public void mostrarFecha(){

        String[] mesesString = getResources().getStringArray(R.array.meses);

        textoFecha.setText(dia + " de " + mesesString[mes] + " del " + año);

    }

}
