package org.whatever.db.core.ser;

import org.jetbrains.annotations.Nullable;
import org.whatever.db.api.DataInput2;
import org.whatever.db.api.DataOutput2;

/**
 * Created by jan on 2/28/16.
 */
public class CharSerializer extends DefaultGroupSerializer<Character> {
    @Override
    public void serialize(DataOutput2 out, Character value) {
        out.writeChar(value.charValue());
    }

    @Override
    public Character deserialize(DataInput2 in) {
        return in.readChar();
    }

    @Nullable
    @Override
    public Class serializedType() {
        return Character.class;
    }

    @Override
    public int fixedSize() {
        return 2;
    }

    @Override
    public boolean isTrusted() {
        return true;
    }

    //TODO value array
}
