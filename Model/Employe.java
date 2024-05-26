
package Model;
public class Employe {
    private int count = 0;
    public String nomEmploye;
    public int numEmploye;
    public String prenomEmploye;
    
    public Employe(String nomEmploye, String prenomEmploye) {
        this.nomEmploye = nomEmploye;
        this.numEmploye = ++count;
        this.prenomEmploye = prenomEmploye;
    }

    public void setNomEmploye(String nomEmploye) {
        this.nomEmploye = nomEmploye;
    }
    
    public String getNomEmploye() {
        return this.nomEmploye;
    }
    public void setNumEmploye(int numEmploye) {

        if (numEmploye <=0) {
            System.out.println("Le numéro employé doit être positif.");
        } else {
        this.numEmploye = numEmploye;
        }
    }
    public int getNumEmploye() {
        return numEmploye;
    }
    public void setPrenomEmploye(String prenomEmploye) {

        if (prenomEmploye != null && !prenomEmploye.isEmpty()) { 
            
        StringBuilder prenomMajuscule = new StringBuilder();
        prenomMajuscule.append(Character.toUpperCase(prenomEmploye.charAt(0))); 
            
        if (prenomEmploye.length() > 1) { 
            prenomMajuscule.append(prenomEmploye.substring(1)); 
        }
        this.prenomEmploye = prenomMajuscule.toString();
            
    } else {
        System.out.println("Le prénom ne peut pas être null ou vide.");
    }
    }
        
    public String getPrenomEmploye() {
        return prenomEmploye;
    }
//affichage info de l'employe
 public void afficherInfo() {
        System.out.println("Nom: " + nomEmploye);
        System.out.println("Numéro: " + numEmploye);
        System.out.println("Prénom: " + prenomEmploye);
    }

    
}
