package ro.redeul.google.go.inspection;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.internal.runners.JUnit38ClassRunner;
import org.junit.runner.RunWith;

@RunWith(JUnit38ClassRunner.class)
public class UnresolvedSymbolsTest extends GoInspectionTestCase {

    public void testIfScope() throws Exception {
        doTest();
    }

    @Test
    public void testIfScope2() throws Exception {
        doTest();
    }

    @Test
    public void testForWithClause() throws Exception {
        doTest();
    }

    @Test
    @Ignore("broken by new resolver")
    public void testForWithRange() throws Exception {
        doTest();
    }

    @Ignore("broken by new resolver")
    public void testIota() throws Exception {
        doTest();
    }

    @Ignore("broken by new resolver")
    public void testUndefinedTypeInMethodReceiver() throws Exception {
        doTest();
    }

    @Ignore("broken by new resolver")
    public void testCgo() throws Exception {
        doTest();
    }

    @Ignore("broken by new resolver")
    public void testCreateFunction() throws Exception {
        doTest();
    }

    @Ignore("broken by new resolver")
    public void testConversionToPointerType() throws Exception {
        doTest();
    }

    @Ignore("broken by new resolver")
    public void testNullPointerImportDecl() throws Exception {
        doTest();
    }

    public void testClosuresResultParameterUnsolveBug() throws Exception {
        doTest();
    }

    @Ignore("broken by new resolver")
    public void testStructField() throws Exception {
        doTest();
    }

    @Ignore("failing test")
    public void testIssue865() throws Exception {
        doTest();
    }

    @Ignore("failing test")
    public void testIssue858() throws Exception {
        doTestWithDirectory();
    }
}
