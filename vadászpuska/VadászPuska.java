
package vadászpuska;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class VadászPuska {
    String rendszam;
    String ev;
    String motor;
    String ár;

    public VadászPuska(String rendszam, String ev, String motor, String ár) {
        this.rendszam = rendszam;
        this.ev = ev;
        this.motor = motor;
        this.ár = ár;
    }

    @Override
    public String toString() {
        return "Vad\u00e1szPuska{" + "rendszam=" + rendszam + ", ev=" + ev + ", motor=" + motor + ", \u00e1r=" + ár + '}';
    }
    
    

    public static void main(String[] args) throws SQLException {
    ArrayList<VadászPuska> kocsik = new ArrayList<VadászPuska>();
      try {
        File file = new File("C:\\Users\\monit\\Documents\\SuSu\\javak\\vadászPuska\\src\\Autok.csv");
        Scanner scan = new Scanner(file);
        while (scan.hasNextLine()) {
            String data = scan.nextLine();
            String[] dataSplited = data.split(",");
            VadászPuska kocsi = new VadászPuska(dataSplited[0],dataSplited[1],dataSplited[2],dataSplited[3]);
            kocsik.add(kocsi);
        }
        scan.close();
        }
      catch (FileNotFoundException e) {
        System.out.println("File nem találhato");
        e.printStackTrace();
        }
        for (int i = 0; i < kocsik.size(); i++) {
            dataBaseConnect.DBconnect(kocsik.get(i).rendszam, kocsik.get(i).ev, kocsik.get(i).motor, kocsik.get(i).ár);
        }
    }
    
    
}
