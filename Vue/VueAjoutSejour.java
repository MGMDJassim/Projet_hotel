package Vue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Model.Consommation;
import Model.Produit;
import Model.Reservation;
import Model.Sejour;
import Model.Hotel;

public class VueAjoutSejour extends JPanel {
    Hotel hotel;
    Reservation reservation;
    Sejour sejour;
    Fenetre fenetre;
    Consommation consommation;
    JLabel produit = new JLabel("Produit");
    JComboBox<String> listeProduits = new JComboBox<String>();
    JLabel quantite = new JLabel("Quantité");
    JComboBox<Integer> listeQuantite = new JComboBox<Integer>();
    JButton ajouter = new JButton("Ajouter");
    
    public VueAjoutSejour(Reservation reservation, Hotel hotel, Fenetre fenetre) {
        this.reservation = reservation;
        this.hotel = hotel;
        this.fenetre = fenetre;

      
        add(produit);
        add(listeProduits);
    
        for (Produit produit : hotel.listeProduit) {
            listeProduits.addItem(produit.getNom());
        }
        add(quantite);
        add(listeQuantite);

        for (int i = 1; i <= 10; i++) {
            listeQuantite.addItem(i);
        }

        add(ajouter);

        ajouter.addActionListener(e -> {
            if (sejour == null) {
                sejour = new Sejour(reservation);
            }
            Produit produit = hotel.listeProduit.get(listeProduits.getSelectedIndex());
            int quantite = listeQuantite.getSelectedIndex() + 1;
            Consommation consommation = new Consommation(produit, quantite, sejour);
            sejour.ajouterConsommation(consommation);
            hotel.listeConsommation.add(consommation);
            hotel.listeSejour.add(sejour);
            System.out.println("Consommation ajoutée : " + consommation.getProduit().getNom() + " " + consommation.getQuantite());
            System.out.println("Sejour ajouté : " + sejour.getConsommations());
            System.out.println("Reservation : " + sejour.getReservation().getClient().getNomClient());
        });

        setVisible(true);
    }


}
