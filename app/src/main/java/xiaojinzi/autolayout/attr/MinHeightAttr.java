package xiaojinzi.autolayout.attr;

import android.view.View;

import java.lang.reflect.Method;

/**
 * Created by zhy on 15/12/24.
 */
public class MinHeightAttr extends AutoAttr
{
    public MinHeightAttr(int pxVal, int baseWidth, int baseHeight)
    {
        super(pxVal, baseWidth, baseHeight);
    }

    @Override
    protected int attrVal()
    {
        return Attrs.MIN_HEIGHT;
    }

    @Override
    protected boolean defaultBaseWidth()
    {
        return false;
    }

    @Override
    protected void execute(View view, int val)
    {
        try
        {
            Method setMaxWidthMethod = view.getClass().getMethod("setMinHeight", int.class);
            setMaxWidthMethod.invoke(view, val);
        } catch (Exception ignore)
        {
        }
    }
}
