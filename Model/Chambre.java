package Model;
import java.util.List;
import java.util.Vector;
import java.time.*;

public class Chambre {
    public int etage;
    public int numeroPorte;
    private Vector<Reservation> listReservation = new Vector<Reservation>();
    public Hotel hotel;
    public String type;

    public Chambre(int etage, int numPorte, String type, Hotel hotel) {
        this.etage = etage;
        this.numeroPorte = numPorte;
        this.type = type;
        this.hotel = hotel;
    }

    public void setEtage(int etage) {
        this.etage = etage;
    }

    public void setNumeroPorte(int numeroPorte) {
        this.numeroPorte = numeroPorte;
    }

    public void addReservation(Reservation reservation) {
        listReservation.add(reservation);
    }
    public void setListReservation(Vector<Reservation> listReservation) {
        this.listReservation = listReservation;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public int getEtage() {
        return etage;
    }

    public int getNumeroPorte() {
        return numeroPorte;
    }

    public List<Reservation> getListReservation() {
        return listReservation;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    // Recherche des chambres libres
    public boolean isFree(LocalDate debut, LocalDate fin) {
        for (Reservation reservation : listReservation) {
            if (reservation.dateD.isBefore(debut) && reservation.datef.isAfter(debut)) {
                return false;
            }
            if (reservation.dateD.isBefore(fin) && reservation.datef.isAfter(fin)) {
                return false;
            }
            if (reservation.dateD.isAfter(debut) && reservation.datef.isBefore(fin)) {
                return false;
            }
        }
        return true;
    }
    // Méthode pour afficher les chambres libres
  /*  public static void afficherChambresLibres(List<Chambre> chambres, Date debut, Date fin) {
        for (Chambre chambre : chambres) {
            if (chambre.isFree(debut, fin)) {
                System.out.println("Chambre " + chambre.type + " à l'étage " + chambre.etage + ", à la porte " + chambre.numeroPorte);
            }
        }
        System.out.println("Aucune chambre n'est disponible sur la période du " + debut + " au " + fin + ".");
    }
*/

}