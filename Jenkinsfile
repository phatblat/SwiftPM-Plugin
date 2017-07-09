/*
 * Jenkinsfile
 * SwiftPM-Plugin
 */

String gitRepoUrl = 'git@github.com:phatblat/SwiftPM-Plugin.git'
String gitCredentials = '6715cdce-69af-499f-a621-05488b298ae1'
String gitRefspec = '+refs/heads/*:refs/remotes/origin/* +refs/pull/*:refs/remotes/origin/pr/*'

node {
    stage('Clone') {
        step([$class: 'WsCleanup'])
        if (env.sha1) {
            // PRB needs custom refspec
            Map scm = [
                $class: 'GitSCM',
                branches: [[name: env.sha1]],
                extensions: [
                    //[$class: 'RelativeTargetDirectory', relativeTargetDir: conf.dir],
                    //[$class: 'CleanCheckout'],
                    //[$class: 'PruneStaleBranch']
                ],
                userRemoteConfigs: [[
                    credentialsId:  gitCredentials,
                    refspec: gitRefspec,
                    url: gitRepoUrl
                ]]
            ]
            checkout scm
        } else {
            // Normal build
            git gitRepoUrl
        }
    }
    stage('Build') {
        sh './gradlew build'
    }
    stage('Check') {
        sh './gradlew build'
    }
    stage('Assemble') {
        sh './gradlew assemble'
    }
    stage('Archive') {
        archiveArtifacts artifacts: 'build/libs/*.jar', fingerprint: true
    }
}