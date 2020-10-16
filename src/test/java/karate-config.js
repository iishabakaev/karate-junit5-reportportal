function fn() {
  // get system property 'karate.env' ( ex: .\gradlew test '-Dkarate.env=prod' )
  var env = karate.env; 
  if (!env) {
    env = 'preprod';
  }
  karate.log('karate.env system property was:', env);

  // don't waste time waiting for a connection or if servers don't respond within 5 seconds
  karate.configure('connectTimeout', 3000);
  karate.configure('readTimeout', 3000);
}