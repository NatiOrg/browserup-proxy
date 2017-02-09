package net.lightbody.bmp.proxy;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.lightbody.bmp.core.har.HarEntry;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by ebeland on 2/7/17.
 */
public class HarEntryTest {

  @Test
  public void testTags() throws Exception {
    HarEntry harEntry = new HarEntry();
    harEntry.addTag("_foo", "bar");
    assertEquals("bar", harEntry.get_tags().get("_foo"));
  }

  @Test
  public void testTagSerialization() throws Exception {
    HarEntry harEntry = new HarEntry();

    harEntry.addTag("foo", "bar");
    String json = new ObjectMapper().writeValueAsString(harEntry);

    assertTrue(json.contains("bar"));
    assertTrue(json.contains("_tags"));
  }

  @Test
  public void testMetricSerialization() throws Exception {
    HarEntry harEntry = new HarEntry();

    harEntry.addMetric("boo", 4);
    String json = new ObjectMapper().writeValueAsString(harEntry);

    assertTrue(json.contains("_metrics"));
    assertTrue(json.contains("boo"));
    assertTrue(json.contains("4"));
  }

}