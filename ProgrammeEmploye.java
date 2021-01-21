
/**
 * Description de la classe:
 * Cette classe permet de calculer le bonus (choix 1), l'augmentation de salaire (choix 2) ou
 * les deux (choix 3) selon le choix de l'utilisateur. Pour quitter le programme, il suffit d'entrer 
 * la touche 0 lors du saisie de choix.
 */
import java.util.*;

public class ProgrammeEmploye {
    // Déclaration des messages.
    static final String BIENVENUE = "Bienvenue.";
    static final String RESUME = "Ce programme permet de calculer le bonus,l'augmentation de salaire ou les deux, basé sur votre note d'évaluation de performance.";
    static final String MENU = "\n\nChoix de menu:\n0. Quitter\n1. Calcul de bonus\n2. Calcul d'augmentation de salaire\n3. Calcul de bonus et d'augmentation de salaire\n";
    static final String CHOIX = "Veuillez entrer votre choix :\n";
    static final String ENTRER_MATRICULE = "Entrez le matricule :";
    static final String ENTRER_NOM = "Entrez le nom :";
    static final String ENTRER_PRENOM = "Entrez le prénom :";
    static final String ENTRER_ECHELON = "Entrez l'échelon :";
    static final String ENTRER_SALAIRE = "Entrez le salaire :";
    static final String ENTRER_NOTE = "Entrez la note d'évaluation de la performance :";
    static final String MESSAGE_REMERCIEMENT = "\nMerci et à la prochaine.";

    // Messages invalides
    static final String CHOIX_MENU_INVALIDE = "Choix du menu invalide.";
    static final String MATRICULE_INVALIDE = "Matricule d'employé invalide.";
    static final String NOM_INVALIDE = "Nom d'employé invalide.";
    static final String PRENOM_INVALIDE = "Prénom d'employé invalide.";
    static final String ECHELON_INVALIDE = "Échelon invalide.";
    static final String SALAIRE_INVALIDE = "Salaire de l'employé invalide.";
    static final String NOTE_INVALIDE = "La note d’évaluation de la performance invalide!";

    // Déclaration des variables constantes.
    static final double TAUX_AUG_0 = 0.0;
    static final double TAUX_AUG_25 = 2.5;
    static final double TAUX_AUG_275 = 2.75;
    static final double TAUX_AUG_3 = 3.0;

    static final String DESCRIPTION_D = "Dépasse";
    static final String DESCRIPTION_A = "Atteint";
    static final String DESCRIPTION_P = "Partiellement Atteint";
    static final String DESCRIPTION_N = "Non Atteint";

    static final double TAUX_BONUS_0 = 0.0;
    static final double TAUX_BONUS_3 = 3.0;
    static final double TAUX_BONUS_5 = 5.0;
    static final double TAUX_BONUS_55 = 5.5;
    static final double TAUX_BONUS_7 = 7.0;
    static final double TAUX_BONUS_75 = 7.5;
    static final double TAUX_BONUS_10 = 10.0;
    static final double TAUX_BONUS_105 = 10.5;
    public static final double TAUX_BONUS_15 = 15.0;

    // Déclaration des variables non constantes.
    static String matricule;
    static String nom;
    static String prenom;
    static int echelon;
    static double salaireInitial = 0;
    static char noteEvaluation = ' ';
    static String descriptionNote = " ";

    static int choix;

    static double tauxBonus = 0;
    static double bonus = 0;
    static double tauxAugSalaire = 0;
    static double montantAugSalaire = 0;
    static double salaireApres = 0;

    static boolean reponseNonValide = true;

    static Scanner entree = new Scanner(System.in);

    /**
     * Cette méthode affiche un message de bienvenue et le résumé du programme.
     */
    public static void afficherBienvenue() {
        System.out.println(BIENVENUE);
        System.out.println(RESUME);
    }

    /**
     * Cette méthode affiche le menu de choix disponibles.
     */
    public static void afficherMenu() {
        System.out.println(MENU);
    }

    /**
     * Cette méthode saisit le choix d'entrée par l'utilisateur. Un message d'erreur
     * apparait aussitôt qu'un choix invalide est saisie, alors l'utilisateur doit
     * resaisir le choix.
     * 
     * @return choix Un entier représentant le choix du menu.
     */
    public static int saisirChoix() {
        do {
            try {
                System.out.println(CHOIX);
                choix = entree.nextInt();
                if (choix < 0 || choix > 3) {
                    System.out.println(CHOIX_MENU_INVALIDE);
                } else {
                    reponseNonValide = false;
                }
            } catch (Exception e) {
                System.out.println(CHOIX_MENU_INVALIDE);
                entree.nextLine();
            }
        } while (reponseNonValide);
        return choix;
    }

    /**
     * Cette méthode saisit la matricule. Un message d'erreur apparait aussitôt que
     * la matricule ne respecte pas les critères, alors l'utilisateur doit resaisir
     * la matricule.
     * 
     * @return matricule Une chaine de caractères représentant la matricule.
     */
    public static String saisirMatricule() {
        do {
            System.out.println(ENTRER_MATRICULE);
            matricule = entree.next();
            matricule = matricule.trim();
            int taille = matricule.length();
            int j = 5;
            String check = matricule.toUpperCase();

            if (taille == 6) {
                for (int i = 0; i < 4; i++) {
                    if (check.charAt(i) < 'A' || check.charAt(i) > 'Z') {
                        // reponseNonValide = true;
                        i = 5;
                        j = 6;
                    } else {
                        reponseNonValide = false;
                    }

                }

                if (j != 6) {
                    for (int i = 4; i < 6; i++) {

                        if (check.charAt(i) < '0' || check.charAt(i) > '9') {
                            // reponseNonValide = true;
                            i = 6;
                            j = 6;
                        }

                    }

                }

            } else {
                reponseNonValide = true;
            }

            if (reponseNonValide == true) {
                System.out.println(MATRICULE_INVALIDE);
            }
        } while (reponseNonValide);
        return matricule;
    }

    /**
     * Cette méthode saisit le nom. Un message d'erreur apparait aussitôt que le nom
     * ne respecte pas les critères, alors l'utilisateur doit resaisir le nom.
     * 
     * @return nom Une chaine de caractères qui représente le nom.
     */
    public static String saisirNom() {
        do {
            System.out.println(ENTRER_NOM);
            nom = entree.next();
            nom = nom.trim();
            int taille = nom.length();

            if (taille < 2 || taille > 30) {
                reponseNonValide = true;
                System.out.println(NOM_INVALIDE);
            } else {
                reponseNonValide = false;
            }
        } while (reponseNonValide);
        return nom;
    }

    /**
     * Cette méthode saisit le prénom. Un message d'erreur apparait aussitôt que le
     * prénom ne respecte pas les critères, alors l'utilisateur doit resaisir le
     * prénom.
     * 
     * @return nom Une chaine de caractères qui représente le nom.
     */
    public static String saisirPrenom() {
        do {
            System.out.println(ENTRER_PRENOM);
            prenom = entree.next();
            prenom = prenom.trim();
            int taille = prenom.length();

            if (taille < 2 || taille > 30) {
                reponseNonValide = true;
                System.out.println(PRENOM_INVALIDE);
            } else {
                reponseNonValide = false;
            }
        } while (reponseNonValide);
        return prenom;
    }

    /**
     * Cette méthode saisit l'échelon. Un message d'erreur apparait aussitôt que
     * l'échelon ne respecte pas les critères, alors l'utilisateur doit resaisir
     * l'échelon. @ return echelon Un nombre entier représentant l'échelon de
     * l'employé.
     */
    public static int saisirEchelon() {
        do {
            System.out.println(ENTRER_ECHELON);
            echelon = entree.nextInt();

            if ((echelon == 1) || (echelon == 2) || (echelon == 3)) {
                reponseNonValide = false;
            } else {
                reponseNonValide = true;
                System.out.println(ECHELON_INVALIDE);
            }

        } while (reponseNonValide);
        return echelon;
    }

    /**
     * Cette méthode saisit le salaire. Un message d'erreur apparait aussitôt que le
     * salaire est négative, alors l'utilisateur doit resaisir le salaire.
     * 
     * @return salaire Un nombre réel représentant le salaire.
     */
    public static double saisirSalaire() {
        do {
            System.out.println(ENTRER_SALAIRE);
            salaireInitial = entree.nextDouble();

            if (salaireInitial < 0) {
                reponseNonValide = true;
                System.out.println(SALAIRE_INVALIDE);
            } else if (salaireInitial >= 0) {
                reponseNonValide = false;
            }

        } while (reponseNonValide);
        return salaireInitial;
    }

    /**
     * Cette méthode saisit la note d'évaluation de la performance. Un message
     * d'erreur apparait aussitôt que la note est différent de D,A,P ou N, alors
     * l'utilisateur doit resaisir la note.
     * 
     * @return noteEvaluation Une chaine de caractères représentant la note
     *         d'évaluation de la performance.
     */
    public static char saisirNote() {
        do {
            System.out.println(ENTRER_NOTE);
            noteEvaluation = entree.next().charAt(0);
            if ((noteEvaluation == 'D') || (noteEvaluation == 'A') || (noteEvaluation == 'P')
                    || (noteEvaluation == 'N')) {
                reponseNonValide = false;
            } else {
                reponseNonValide = true;
                System.out.println(NOTE_INVALIDE);
            }

        } while (reponseNonValide);

        return noteEvaluation;
    }

    /**
     * Cette méthode assigne la description de la note d'évaluation de performance
     * selon la note saisie.
     * 
     * @param noteEvaluation Une chaine de caractères représentant la note
     *                       d'évaluation de la performance.
     * @return descriptionNote Une chaine de caractères représentant la description
     *         de la note d'évaluation de la performance.
     */
    public static String DeterminerDescriptionNote(char noteEvaluation) {

        if (noteEvaluation == 'D') {
            descriptionNote = DESCRIPTION_D;
        } else if (noteEvaluation == 'A') {
            descriptionNote = DESCRIPTION_A;
        } else if (noteEvaluation == 'P') {
            descriptionNote = DESCRIPTION_P;
        } else if (noteEvaluation == 'N') {
            descriptionNote = DESCRIPTION_N;
        }
        return descriptionNote;
    }

    /**
     * Cette méthode détermine le taux de bonus en fonction de l'échelon et de la
     * note d'évaluation de la performance. Le bonus équivaut à 0 si la note
     * corrspond à 'N'.
     * 
     * @param echelon        Un entier représentant l'échelon.
     * @param noteEvaluation Une chaine de caractères représentant la note
     *                       d'évaluation de la performance.
     * @return tauxBonus Un nombre réel représentant le taux de bonus.
     */
    public static double calculerTauxBonus(int echelon, char noteEvaluation) {
        if (noteEvaluation != 'N') {
            if (echelon == 1) {

                if (noteEvaluation == 'D') {
                    tauxBonus = TAUX_BONUS_75;
                } else if (noteEvaluation == 'A') {
                    tauxBonus = TAUX_BONUS_55;
                } else if (noteEvaluation == 'P') {
                    tauxBonus = TAUX_BONUS_3;
                }

            } else if (echelon == 2) {

                if (noteEvaluation == 'D') {
                    tauxBonus = TAUX_BONUS_10;
                } else if (noteEvaluation == 'A') {
                    tauxBonus = TAUX_BONUS_75;
                } else if (noteEvaluation == 'P') {
                    tauxBonus = TAUX_BONUS_5;
                }

            } else if (echelon == 3) {

                if (noteEvaluation == 'D') {
                    tauxBonus = TAUX_BONUS_15;
                } else if (noteEvaluation == 'A') {
                    tauxBonus = TAUX_BONUS_105;
                } else if (noteEvaluation == 'P') {
                    tauxBonus = TAUX_BONUS_7;
                }

            }
        } else {
            tauxBonus = TAUX_BONUS_0;
        }
        return tauxBonus;
    }

    /**
     * Cette méthode détermine le taux d'augmentation de salaire selon l'échelon.
     * 
     * @param echelon Un entier représentant l'échelon.
     * @return tauxAugSalaire Un nombre réel représentant le taux d'augmentation de
     *         salaire.
     */
    public static double calculerTauxAug(int echelon) {
        if (echelon == 1) {
            tauxAugSalaire = TAUX_AUG_25;
        } else if (echelon == 2) {
            tauxAugSalaire = TAUX_AUG_275;
        } else if (echelon == 3) {
            tauxAugSalaire = TAUX_AUG_3;
        }
        return tauxAugSalaire;
    }

    /**
     * Cette méthode calcule le montant de bonus selon le taux de bonus et le
     * salaire initial.
     * 
     * @param tauxBonus      Un nombre réel représentant le taux de bonus.
     * @param salaireInitial Un nombre réel représentant le salaire saisi.
     * @return bonus Un nombre réel représentant le montant du bonus.
     */
    public static double calculerMontantBonus(double tauxBonus, double salaireInitial) {
        bonus = (tauxBonus * salaireInitial) / 100;
        return bonus;
    }

    /**
     * Cette méthode calcule le montant d'augmentation de salaire selon le taux
     * d'augmentation de salaire et le salaire saisi.
     * 
     * @param tauxAugSalaire Un nombre réel représentant le taux d'augmentation de
     *                       salaire.
     * @param salaireInitial Un nombre réel représentant le salaire saisi.
     * @return montantAugSalaire Un nombre réel représentant montant d'augmentation
     *         de salaire.
     */
    public static double calculerMontantAugmentationSalaire(double tauxAugSalaire, double salaireInitial) {
        montantAugSalaire = (tauxAugSalaire * salaireInitial) / 100;
        return montantAugSalaire;
    }

    /**
     * Cette méthode calcule le salaire final basé sur le salaire initial et le
     * montant d'augmentation de salaire.
     * 
     * @param salaireInitial    Un nombre réel représentant le salaire saisi.
     * @param montantAugSalaire Un nombre réel représentant montant d'augmentation
     *                          de salaire.
     * @return salaireApres Un nombre réel représentant le salaire final.
     */
    public static double calculerSalaireFinal(double salaireInitial, double montantAugSalaire) {
        salaireApres = salaireInitial + montantAugSalaire;
        return salaireApres;
    }

    // Si utilisateur decide de terminer
    /**
     * Cette méthode affiche un message de remerciement après que le choix de
     * l'utilisateur correspond à 0.
     */
    public static void afficherSortie() {
        System.out.println(MESSAGE_REMERCIEMENT);
    }

    /**
     * Cette méthode affiche les informations commune aux trois choix.
     */
    public static void afficherInformationCommune() {
        System.out.println("\nMatricule : " + matricule);
        System.out.println("Nom et Prenom : " + nom + " " + prenom);
        System.out.println("Échelon : " + echelon);
        System.out.printf("Salaire : %.2f", salaireInitial);
    }

    /**
     * Cette méthode effectue la saisie des informations commune aux trois choix.
     * 
     * @param choix Le choix de l'utilisateur en entrée.
     */
    public static void saisirInformationCommune(int choix) {
        saisirMatricule();
        saisirNom();
        saisirPrenom();
        saisirEchelon();
        saisirSalaire();

        if (choix == 1 || choix == 3) {
            saisirNote();
            DeterminerDescriptionNote(noteEvaluation);
        }
    }

    /**
     * Cette méthode effectue la saisie de l'information et l'affichage des
     * résultats pour le premier choix.
     */
    public static void executerPremierChoix() {
        saisirInformationCommune(choix);

        calculerTauxBonus(echelon, noteEvaluation);
        calculerMontantBonus(tauxBonus, salaireInitial);

        afficherInformationCommune();
        System.out.println("\nÉvaluation de la performance : " + descriptionNote);
        System.out.println("Taux de bonus : " + tauxBonus);
        System.out.printf("Bonus : %.2f", bonus);
    }

    /**
     * Cette méthode effectue la saisie de l'information et l'affichage des
     * résultats pour le deuxième choix.
     */
    public static void executerDeuxiemeChoix() {
        saisirInformationCommune(choix);
        calculerTauxAug(echelon);
        calculerMontantAugmentationSalaire(tauxAugSalaire, salaireInitial);
        calculerSalaireFinal(salaireInitial, montantAugSalaire);

        afficherInformationCommune();
        System.out.println("\nTaux de l'augmentation de salaire : " + tauxAugSalaire);
        System.out.printf("Montant - Augmentation de salaire : %.2f ", montantAugSalaire);
        System.out.printf("\nSalaire après augmentation : %.2f ", salaireApres);
    }

    /**
     * Cette méthode effectue la saisie de l'information et l'affichage des
     * résultats pour le troisième choix.
     */
    public static void executerTroisiemeChoix() {
        saisirInformationCommune(choix);

        calculerTauxBonus(echelon, noteEvaluation);
        calculerMontantBonus(tauxBonus, salaireInitial);
        calculerTauxAug(echelon);
        calculerMontantAugmentationSalaire(tauxAugSalaire, salaireInitial);
        calculerSalaireFinal(salaireInitial, montantAugSalaire);

        afficherInformationCommune();
        System.out.println("\nTaux de bonus : " + tauxBonus);
        System.out.println("Bonus : " + bonus);
        System.out.println("Taux de l'augmentation de salaire : " + tauxAugSalaire);
        System.out.printf("Montant - Augmentation de salaire : %.2f ", montantAugSalaire);
        System.out.printf("\nSalaire après augmentation : %.2f ", salaireApres);
    }

    /**
     * Cette méthode affiche le menu du programme et prends le choix de
     * l'utilisateur.
     */
    public static void debut() {
        afficherMenu();
        saisirChoix();
    }

    /**
     * Cette méthode exécute les options selon le choix de l'utilisateur jusqu'à la
     * sortie.
     */
    public static void demarrer() {
        while (choix != 0) {
            if (choix == 1) {
                executerPremierChoix();
            } else if (choix == 2) {
                executerDeuxiemeChoix();
            } else if (choix == 3) {
                executerTroisiemeChoix();
            }
            // Réaffichage du choix de menu.
            debut();
        }
    }

    /**
     * Cette méthode main appelle les méthodes contenues à l'extérieur de la méthode
     * main. Le scénario d'affichage dépend du choix de l'utilisateur. Le programme
     * continuera tant que le chiffre 0 n'est pas saisi lors du demande de choix.
     */
    public static void main(String[] params) {
        afficherBienvenue();
        debut();
        demarrer();
        afficherSortie();
    }
}
