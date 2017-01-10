package emailTest;

import email.Emails;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by vadim on 20.09.16.
 */
public class EmailTest
{
    @Test
    public void test1()
    {
        Assert.assertTrue(Emails.email_correct("sdfsd@sdhf.ru"));
    }
}
