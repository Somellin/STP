package junit;

import org.junit.platform.engine.DiscoverySelector;
import org.junit.platform.engine.discovery.DiscoverySelectors;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import tests.stp.FractionTest;
import tests.stp.MathFractionTest;

import java.io.PrintWriter;

public class TestLauncher {
    public static void main(String[] args) {

        SummaryGeneratingListener summaryGeneratingListener = new SummaryGeneratingListener();

        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder
                .request()
                .selectors(DiscoverySelectors.selectClass(FractionTest.class))
                .selectors(DiscoverySelectors.selectClass(MathFractionTest.class))
                .build();
        LauncherFactory.create()
                .execute(request,summaryGeneratingListener);

        try(PrintWriter writer = new PrintWriter(System.out)){
            summaryGeneratingListener.getSummary().printTo(writer);
        }
    }
}
