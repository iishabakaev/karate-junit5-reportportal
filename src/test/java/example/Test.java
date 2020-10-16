package example;

import com.epam.reportportal.junit5.ReportPortalExtension;
import com.intuit.karate.junit5.Karate;

import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(ReportPortalExtension.class)
class Test {

  @Karate.Test
  Karate runTests() {
    // Search file karate-test.feature and run it. 
    // Leave it blank if you want run all .feature files relative to this test
    return Karate.run("karate-test").relativeTo(getClass());
  }

}
