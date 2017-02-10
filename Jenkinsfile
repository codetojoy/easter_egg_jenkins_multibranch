#!groovy

stage "initial checkout"

node {
    checkout scm
}

stage "build"
node {
    withEnv([
        "TRUNK_MAJOR_VERSION=0",
        "TRUNK_MINOR_VERSION=9",
        "TRUNK_INCREMENTAL_VERSION=8",
        "TRUNK_QUALIFIER=SNAPSHOT",
        "TRUNK_BUILD_NUMBER=${env.BUILD_NUMBER}"
        ]) {

        def gradleHome = tool "G31"

        sh "${gradleHome}/bin/gradle clean build -p utils"
    }
}

stage "run script"
node {
    sh "chmod 777 ${env.WORKSPACE}/utils/run.sh"
    sh "${env.WORKSPACE}/utils/run.sh ${env.WORKSPACE}"
}

stage('post build') {
    when {
        expression {
            GIT_BRANCH = sh(returnStdout: true, script: 'git rev-parse --abbrev-ref HEAD').trim()
            return GIT_BRANCH == 'master'
        }
    }
    steps {
        echo "master branch detected : WOULD DEPLOY HERE"
    }
}
