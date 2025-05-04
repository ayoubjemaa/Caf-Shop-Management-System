# Caf-Shop-Management-System

Projet Universitqre Application desktop Java pour la gestion d’un café, avec interface JavaFX (utilisant outils scene builder ), gestion des commandes et stock, tableaux de bord analytiques, architecture orientée objet, base de données MariaDB via XAMPP, et communication client-serveur via JDBC.


## 📸 Des captures d'écran sur les différentes interfaces graphiques de l'application :

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


---

## 🛠️ Les technologies utilisées : 


1. Back-End :

Java : Pour la logique métier et les services back-end.
JDBC (Java Database Connectivity) : Pour la connexion à la base de données SQL.

2. Front-End :
   
JavaFX : Pour créer des interfaces utilisateur modernes et interactives en Java.
Scene Builder : Pour concevoir visuellement les interfaces utilisateur JavaFX.
FXML : Pour décrire la structure de l'interface utilisateur (lié à Scene Builder).

3. Base de Données :
   
MySQL (ou une autre base relationnelle) : Pour stocker les données.
JDBC : Pour la connexion Java à la base de données.

4. Bibliothèques Additionnelles (fichiers JAR) :
   
SQL Connector JDBC : Pour connecter Java à MySQL (ou autre).
Font-Awesome : Pour les icônes.

🔧 Configuration de la base de données  : 

1. Installation de XAMPP 🔧
Installez XAMPP depuis le site officiel.

Lancez les services Apache 🌐 et MySQL 🗄️ via le panneau de contrôle XAMPP.

2. Accéder à phpMyAdmin 🖥️
Ouvrez votre navigateur et allez sur http://localhost/phpmyadmin/ pour accéder à phpMyAdmin.

3. Créer une base de données ➕
Dans phpMyAdmin, allez dans l'onglet Bases de données.

Entrez un nom pour votre base de données (par exemple, cafe_shop_db) et cliquez sur Créer.

4. Créer les tables 🏗️
Sélectionnez la base de données nouvellement créée.

Cliquez sur Nouvelle pour créer une nouvelle table.

Définissez le nom de la table et le nombre de colonnes.

Entrez les détails de chaque colonne (nom, type de données, longueur, etc.) et cliquez sur Enregistrer.

5. Insérer des données 💾
Après la création des tables, cliquez sur Insérer pour ajouter des données dans les tables.

Remplissez les champs avec les données nécessaires et cliquez sur Exécuter.

6. Exécuter des requêtes SQL ⚙️
Dans phpMyAdmin, vous pouvez utiliser l'onglet SQL pour entrer et exécuter des requêtes SQL, comme SELECT, INSERT, UPDATE, et DELETE.

7. Utiliser JDBC pour connecter Java à la base de données 🔗
Téléchargez le connecteur JDBC pour MariaDB ou MySQL et ajoutez-le à votre projet Java.
---
## 📂 Structure du projet 
```bash
CafeShopManagementSys/
├── src/
│   └── main/
│       ├── java/
│       │   └── cafeshopmanagementsys/
│       │       ├── CafeShopManagementSys.java        # Classe principale (point d'entrée)
│       │       ├── CustomersData.java                # Modèle des données clients
│       │       ├── ProductData.java                  # Modèle des données produits
│       │       ├── DataBase.java                     # Gestion de la base de données
│       │       ├── FXMLDocumentController.java       # Contrôleur de l'authentification
│       │       ├── mainFormController.java           # Contrôleur de l'interface principale
│       │       ├── RecuController.java               # Contrôleur pour la génération des reçus
│       │       └── cardProductController.java        # Contrôleur des cartes de produits
│       └── resources/
│           ├── FXMLDocument.fxml                    # Vue de l'authentification
│           ├── mainForm.fxml                        # Vue principale de l'application
│           ├── recu.fxml                            # Vue des reçus
│           ├── cardProduct.fxml                     # Vue des cartes de produits
│           ├── LoginDesign.css                      # Styles pour la page d'authentification
│           ├── mainFormDesign.css                  # Styles de l'interface principale
│           ├── cardDesign.css                      # Styles des cartes de produits
│           └── report.jrxml                        # Template JasperReports pour l'impression des reçus
├── test/
│   └── java/                                       # Tests unitaires (non structurés pour l'instant)
├── lib/
│   ├── mysql-connector-java-5.1.48.jar             # Pilote MySQL pour la connexion à la base de données
│   ├── ojdbc14-10.2.0.2.0.jar                     # Pilote Oracle pour la connexion à la base de données
│   └── fontawesomefx-8.2.jar                       # Icônes FontAwesome pour l'interface utilisateur
└── target/                                         # Dossier de compilation (généré automatiquement)
```
---

### 🔍 Les diagrammes de classes : 
```
+────────────+       +────────────+       +─────────────+
|  customer  |       |  receipt   |       |  product    |
+────────────+       +────────────+       +─────────────+
| customer_id|◄─────►| receipt_id |       | product_id  |
| name       |       | customer_id|◄─┐    | name        |
| email      |       | employee_id│  │    | price       |
| phone      |       | date       │  │    | stock       |
| address    |       | total_amount┘  │    | category    |
+────────────+       +────────────+    │    +─────────────+
                                       │
+────────────+                         │    +──────────────────+
|  employee  |                         └───►| receipt_details  |
+────────────+                              +──────────────────+
| employee_id|◄─────────────────────────────| receipt_id       |
| first_name |                              | product_id       |
| last_name  |                              | quantity         |
| role       |                              | unit_price       |
| hire_date  |                              | subtotal         |
+────────────+                              +──────────────────+

```
---

## 💻 Usage
Voici comment utiliser les différentes fonctionnalités de l'application Cafe Shop Management System :

🔐 Connexion
Lancez l’application via l’interface principale.

Connectez-vous avec votre nom d'utilisateur (admin ou caissier).

🧭 Tableau de bord (Dashboard)

Visualisez :
Le revenu total
Le nombre de clients servis
Le nombre total de produits vendus
Le revenu du jour
Analysez les graphiques :
📈 Income Chart : évolution des revenus par date.
👤 Customer's Chart : fréquentation des clients.
📦 Gestion de l’inventaire (Inventory)
Affiche tous les produits disponibles dans le café.

Pour chaque produit :
📝 Modifier ses informations (nom, prix, stock…)
➕ Ajouter un nouveau produit
🗑️ Supprimer un produit
🖼️ Voir son image
Les changements sont automatiquement enregistrés dans la base de données.

🍽️ Menu (Commande client)

Ajoutez les produits à la commande via des cartes produit affichées dynamiquement.
Sélectionnez la quantité et ajoutez au panier.
Le système calcule automatiquement le total.
Cliquez sur "Save Order" pour enregistrer la commande.
Cliquez sur "Print Receipt" pour imprimer un reçu avec les détails.

👥 Clients (Customers)

Consultez la liste des clients ayant passé commande.
Visualisez :
Leur identifiant
Les montants payés
Seuls les clients liés à l’utilisateur connecté (admin/caissier) sont visibles.
🧾 Reçu
Après avoir passé une commande, vous pouvez imprimer un reçu :
Liste des produits commandés
Quantité, type, prix
Total de la commande
ID du client
Date et heure de l’impression (fixe)
## Prérequis

Avant de commencer l'installation, assurez-vous d'avoir les outils suivants installés sur votre machine :

- **Git** : Pour cloner le dépôt depuis GitHub.
  - Téléchargez et installez Git depuis [git-scm.com](https://git-scm.com/).
- **Java Development Kit (JDK)** : Version 8 ou supérieure recommandée.
  - Téléchargez et installez le JDK depuis [Oracle](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) ou via un gestionnaire de paquets.
- **IDE Java** : Par exemple, IntelliJ IDEA, Eclipse ou NetBeans.
- **Base de données MySQL ou Oracle** : Selon la configuration de votre projet.
  - MySQL : [Télécharger MySQL](https://dev.mysql.com/downloads/).
  - Oracle : [Télécharger Oracle DB](https://www.oracle.com/database/technologies/).

---

## 🚀 Application Setup
 1. Cloner le dépôt
Tout d'abord, clonez le projet depuis GitHub. Ouvrez votre terminal et exécutez la commande suivante :
```
git clone https://github.com/votre-utilisateur/CafeShopManagementSys.git
````
📂 Répertoire du projet cloné :
Une fois le projet cloné, naviguez dans le dossier du projet avec cette commande :
````
cd CafeShopManagementSys
````
2. Installer les dépendances
a) Dépendances Java
Si vous utilisez un gestionnaire de dépendances comme Maven ou Gradle, vous devez installer les dépendances du projet.

Maven :
```
mvn install
````

Gradle :
```
gradle build
```

Cela permet d'installer toutes les dépendances nécessaires pour exécuter le projet.
b) Pilotes de base de données

Le projet nécessite les pilotes pour MySQL ou Oracle. Les fichiers sont présents dans le dossier lib/, mais vous pouvez les télécharger manuellement si nécessaire.

MySQL Connector/J : mysql-connector-java-5.1.48.jar

Oracle JDBC Driver : ojdbc14-10.2.0.2.0.jar

Téléchargez-les à partir des liens suivants :
MySQL Connector/J
Oracle JDBC Driver

3. Configurer la base de données
   
Pour que l'application fonctionne correctement, vous devez configurer la base de données :
MySQL : Créez une base de données et configurez-la dans le fichier DataBase.java.
Oracle : Assurez-vous que la connexion à la base de données est correcte dans DataBase.java.
Mise a jour la connection aux paramétres MySQL :
````
db.url=jdbc:mysql://localhost:3306/rentcar
db.user=your_username
db.password=your_password
````

4. Configurer l'IDE
   
Assurez-vous que votre JDK est bien configuré dans votre IDE (par exemple IntelliJ IDEA, Eclipse) :
Dans IntelliJ IDEA :
Allez dans File > Project Structure.
Sous l'onglet Project, définissez la version du JDK.

5. Lancer l'application
   
```
mvn javafx:run
```
Une fois toutes les étapes précédentes effectuées, vous pouvez exécuter l'application.
Dans IntelliJ IDEA :
Ouvrez le fichier CafeShopManagementSys.java situé dans le dossier src/main/java/cafeshopmanagementsys/.
Cliquez sur le bouton "Run" ou utilisez la combinaison de touches Shift + F10 pour démarrer l'application.

6. Tester l'application
   
L'application devrait maintenant démarrer avec l'interface de connexion (FXML). Vous pourrez vous connecter et interagir avec l'interface de gestion des produits, des clients et des ventes.


