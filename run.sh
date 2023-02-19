#!/bin/bash

# Nom du fichier jar
JAR_FILE="tp-1.0-standalone.jar"

# Fonction pour vérifier si le fichier jar existe
function jar_exists() {
  [ -f "$JAR_FILE" ]
}

# Fonction pour créer le fichier jar
function create_jar() {
  # Exécuter le script Maven pour créer le fichier jar
  mvn clean package

  # Copier le fichier jar dans le même répertoire que le script
  cp target/"$JAR_FILE" .
}

# Vérifier si le fichier jar existe
if ! jar_exists; then
  create_jar
  # Transmettre tous les arguments, y compris le nom du script
fi

# Transmettre tous les arguments, y compris le nom du script
java -jar "$JAR_FILE" "$@"
