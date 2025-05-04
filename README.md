# Caf-Shop-Management-System

Projet Universitqre Application desktop Java pour la gestion d’un café, avec interface JavaFX (utilisant outils scene builder ), gestion des commandes et stock, tableaux de bord analytiques, architecture orientée objet, base de données MariaDB via XAMPP, et communication client-serveur via JDBC.

📸 Des captures d'écran sur les différentes interfaces graphiques de l'application :

I/Les interface d'authentification :

interface de registration : 

Elle permet a un utilisateur de devenir un admin (cassier dans notre cas) par la création d'un compt stocké en table employee dans la Base de données "Cafe" créer en SQL

![image](https://github.com/user-attachments/assets/af5751f0-da07-4317-a552-bdf0090f4492)

interface de login : 

Elle permet a un admin de se connecter vers les interfaces principales de l'application 

![image](https://github.com/user-attachments/assets/8a083ad5-225e-4d36-a29b-bbdd71e46e65)

interface forget password : 

Elle permet au admin de réintaliser son mot de passe dans le cas ou il l'a oublié.

![image](https://github.com/user-attachments/assets/33ddb110-03b6-4c81-a63d-9725af0bb8d4)


II/Les interfaces principale de l'application.

🔷 1. Dashboard (Tableau de bord)

Objectif : Fournir un aperçu statistique de l’activité du café.
Fonctions principales :

**Income Chart (Graphique des revenus) :
Affiche les revenus journaliers ou sur une période choisie.
Permet d’analyser les pics d’activité.

**Customer's Chart (Graphique des clients) :
Montre le nombre de clients servis chaque jour.
Permet de suivre la fréquentation du café selon les jours.

Indicateurs affichés :
🔹 Total des revenus générés (total income)
🔹 Nombre total de clients servis
🔹 Nombre total de produits vendus
🔹 Revenu du jour courant (today's income)

![image](https://github.com/user-attachments/assets/390bb648-8636-4010-9bdf-f793817ca9d4)


🔷 2. Inventory (Inventaire des produits)

Objectif : Gérer la base de données des produits proposés dans le café.

Fonctions principales :
Liste des produits :
Nom, type, prix, stock, statut (Disponible / Non disponible), image.
Opérations CRUD :
✅ Ajouter un nouveau produit.
✏️ Modifier un produit existant.
❌ Supprimer un produit.
📸 Visualiser l’image associée à chaque produit.

Utilisation :
Connecté à une base de données via JDBC.
Les images sont chargées dynamiquement pour chaque carte produit (cardProduct.fxml).

![image](https://github.com/user-attachments/assets/b4d8c2c7-9dec-422c-8258-99cec5748a7d)

🔷 3. Menu (Commande client)

Objectif : Gérer la commande des produits par les clients.

Fonctions principales :
Affichage des produits sous forme de cartes (GridPane).
Ajout de produits à la commande :
Sélection de quantité via un Spinner.
Mise à jour du stock après chaque ajout.
Contrôle sur la disponibilité et quantité en stock.
Enregistrement des commandes dans la table customer.
Affichage de la commande courante :
TableView montrant les produits ajoutés.
Calcul automatique du total.
Impression d’un reçu (receipt) :
Utilisation de PrinterJob.
Affichage des produits commandés, date, total, ID client.

![image](https://github.com/user-attachments/assets/d7eeb3cb-01c6-4d08-a340-949e52f0e6e5)

l'interface du reçu du dernier client aprés payement son menu : 

![image](https://github.com/user-attachments/assets/a251f370-1f98-4294-b80c-21415b8b9e16)

🔷 4. Customers (Gestion des clients)
Objectif : Visualiser les informations des clients ayant passé commande.

Fonctions principales :
Liste des clients :
ID client, nom, produits commandés, montants payés.
Vue filtrée par caissier connecté :
L’administrateur (ou employé identifié par Data.getUsername()) ne voit que ses propres ventes.
Utilisation :
Affichage dynamique selon l’utilisateur connecté.
Permet un suivi par employé/caissier.

![image](https://github.com/user-attachments/assets/561f46f4-1c2b-42a2-b716-0356c881604a)




