#!/usr/bin/env groovy

def call() {
    echo "Buildig maven app..."
    sh "mvn package"
}