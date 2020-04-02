# Création de la base de données PostgreSQL

## Par DataGrip

Cliquez sur le "+" en haut du volet de `Database`, puis sur `Data Source` et enfin `PostgreSQL`

![addDataSource](resources/datagrip-add_dataSource.png)

Dans la boite de dialogue qui s'ouvre, renseignez le champ `Name`, `Host`, `Port` comme suit :

![dataSourceAndDrivers](resources/datagrip-dataSourcesAndDrivers_vierge.png)

Renseigner le champ `User` avec le login du compte administrateur PostgreSQL et le champ `Password` avec son mot de passe.

Cliquez ensuite sur `OK`.

Cliquez droit sur le nouveau Data Source, puis sur `New` et `Database`

![newDatabase](resources/datagrip-newDatabase.png)

Dans la nouvelle boite de dialogue, renseigner le nom de la nouvelle table à créer, ici `moviestack_db`.

![newDatabaseName](resources/datagrip-newDatabase_name.png)

Cliquez sur le bouton `Execute`.

Vous verrez votre nouvelle database dans le répertoire `databases`.

A droite de cette database, vous devez voir un petit bouton indiquant un `[0 of 3]`, cliquez sur ce bouton.

Cochez `public` dans les schemas sous le nom de votre database :

![displayPublic](resources/datagrip-displayPublic.png)

Le schema `public` sera visible :

![refresh](resources/datagrip-refresh.png)

Vous pouvez lancer le Backend à ce stade.

Une fois lancé le Backend, vous devez voir les tables sous le répertoire `tables` :

![final](resources/datagrip-final.png)