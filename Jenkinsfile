node{
    stage('SCM Checkout'){
      git 'https://github.com/Barca10/DemoJava.git'
    }
    stage('Compile-Package'){
      sh 'mvn package'
    }
}
