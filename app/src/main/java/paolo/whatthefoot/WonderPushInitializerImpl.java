package paolo.whatthefoot;

import android.content.Context;

import com.wonderpush.sdk.WonderPush;
import com.wonderpush.sdk.WonderPushInitializer;

public class WonderPushInitializerImpl implements WonderPushInitializer {

    public void initialize(Context context) {
        WonderPush.initialize(context, "c05e3cf7a4bbd5a81fe457e7d95015f7e77e959d", "bf19ac9c9b462e27779c24855f49299439c46cdef96a18dc4298cbdae7ded2a9"); // 2 3

    }

}
