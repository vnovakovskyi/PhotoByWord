package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.ProxyUtils;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsList;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.Property;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
public class DBFilePojoRealmProxy extends com.example.vadim.photobyword.pojo.DBFilePojo
    implements RealmObjectProxy, DBFilePojoRealmProxyInterface {

    static final class DBFilePojoColumnInfo extends ColumnInfo {
        long urlIndex;
        long titleIndex;

        DBFilePojoColumnInfo(OsSchemaInfo schemaInfo) {
            super(2);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("DBFilePojo");
            this.urlIndex = addColumnDetails("url", objectSchemaInfo);
            this.titleIndex = addColumnDetails("title", objectSchemaInfo);
        }

        DBFilePojoColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new DBFilePojoColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final DBFilePojoColumnInfo src = (DBFilePojoColumnInfo) rawSrc;
            final DBFilePojoColumnInfo dst = (DBFilePojoColumnInfo) rawDst;
            dst.urlIndex = src.urlIndex;
            dst.titleIndex = src.titleIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>(2);
        fieldNames.add("url");
        fieldNames.add("title");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    private DBFilePojoColumnInfo columnInfo;
    private ProxyState<com.example.vadim.photobyword.pojo.DBFilePojo> proxyState;

    DBFilePojoRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (DBFilePojoColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.example.vadim.photobyword.pojo.DBFilePojo>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$url() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.urlIndex);
    }

    @Override
    public void realmSet$url(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.urlIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.urlIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.urlIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.urlIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$title() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.titleIndex);
    }

    @Override
    public void realmSet$title(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.titleIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.titleIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.titleIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.titleIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("DBFilePojo", 2, 0);
        builder.addPersistedProperty("url", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("title", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static DBFilePojoColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new DBFilePojoColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "DBFilePojo";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.example.vadim.photobyword.pojo.DBFilePojo createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.example.vadim.photobyword.pojo.DBFilePojo obj = realm.createObjectInternal(com.example.vadim.photobyword.pojo.DBFilePojo.class, true, excludeFields);

        final DBFilePojoRealmProxyInterface objProxy = (DBFilePojoRealmProxyInterface) obj;
        if (json.has("url")) {
            if (json.isNull("url")) {
                objProxy.realmSet$url(null);
            } else {
                objProxy.realmSet$url((String) json.getString("url"));
            }
        }
        if (json.has("title")) {
            if (json.isNull("title")) {
                objProxy.realmSet$title(null);
            } else {
                objProxy.realmSet$title((String) json.getString("title"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.example.vadim.photobyword.pojo.DBFilePojo createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.example.vadim.photobyword.pojo.DBFilePojo obj = new com.example.vadim.photobyword.pojo.DBFilePojo();
        final DBFilePojoRealmProxyInterface objProxy = (DBFilePojoRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("url")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$url((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$url(null);
                }
            } else if (name.equals("title")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$title((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$title(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    public static com.example.vadim.photobyword.pojo.DBFilePojo copyOrUpdate(Realm realm, com.example.vadim.photobyword.pojo.DBFilePojo object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null) {
            final BaseRealm otherRealm = ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm();
            if (otherRealm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            }
            if (otherRealm.getPath().equals(realm.getPath())) {
                return object;
            }
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.example.vadim.photobyword.pojo.DBFilePojo) cachedRealmObject;
        }

        return copy(realm, object, update, cache);
    }

    public static com.example.vadim.photobyword.pojo.DBFilePojo copy(Realm realm, com.example.vadim.photobyword.pojo.DBFilePojo newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.example.vadim.photobyword.pojo.DBFilePojo) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.example.vadim.photobyword.pojo.DBFilePojo realmObject = realm.createObjectInternal(com.example.vadim.photobyword.pojo.DBFilePojo.class, false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        DBFilePojoRealmProxyInterface realmObjectSource = (DBFilePojoRealmProxyInterface) newObject;
        DBFilePojoRealmProxyInterface realmObjectCopy = (DBFilePojoRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$url(realmObjectSource.realmGet$url());
        realmObjectCopy.realmSet$title(realmObjectSource.realmGet$title());
        return realmObject;
    }

    public static long insert(Realm realm, com.example.vadim.photobyword.pojo.DBFilePojo object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.vadim.photobyword.pojo.DBFilePojo.class);
        long tableNativePtr = table.getNativePtr();
        DBFilePojoColumnInfo columnInfo = (DBFilePojoColumnInfo) realm.getSchema().getColumnInfo(com.example.vadim.photobyword.pojo.DBFilePojo.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$url = ((DBFilePojoRealmProxyInterface) object).realmGet$url();
        if (realmGet$url != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.urlIndex, rowIndex, realmGet$url, false);
        }
        String realmGet$title = ((DBFilePojoRealmProxyInterface) object).realmGet$title();
        if (realmGet$title != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.vadim.photobyword.pojo.DBFilePojo.class);
        long tableNativePtr = table.getNativePtr();
        DBFilePojoColumnInfo columnInfo = (DBFilePojoColumnInfo) realm.getSchema().getColumnInfo(com.example.vadim.photobyword.pojo.DBFilePojo.class);
        com.example.vadim.photobyword.pojo.DBFilePojo object = null;
        while (objects.hasNext()) {
            object = (com.example.vadim.photobyword.pojo.DBFilePojo) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$url = ((DBFilePojoRealmProxyInterface) object).realmGet$url();
            if (realmGet$url != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.urlIndex, rowIndex, realmGet$url, false);
            }
            String realmGet$title = ((DBFilePojoRealmProxyInterface) object).realmGet$title();
            if (realmGet$title != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.example.vadim.photobyword.pojo.DBFilePojo object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.vadim.photobyword.pojo.DBFilePojo.class);
        long tableNativePtr = table.getNativePtr();
        DBFilePojoColumnInfo columnInfo = (DBFilePojoColumnInfo) realm.getSchema().getColumnInfo(com.example.vadim.photobyword.pojo.DBFilePojo.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$url = ((DBFilePojoRealmProxyInterface) object).realmGet$url();
        if (realmGet$url != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.urlIndex, rowIndex, realmGet$url, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.urlIndex, rowIndex, false);
        }
        String realmGet$title = ((DBFilePojoRealmProxyInterface) object).realmGet$title();
        if (realmGet$title != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.titleIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.vadim.photobyword.pojo.DBFilePojo.class);
        long tableNativePtr = table.getNativePtr();
        DBFilePojoColumnInfo columnInfo = (DBFilePojoColumnInfo) realm.getSchema().getColumnInfo(com.example.vadim.photobyword.pojo.DBFilePojo.class);
        com.example.vadim.photobyword.pojo.DBFilePojo object = null;
        while (objects.hasNext()) {
            object = (com.example.vadim.photobyword.pojo.DBFilePojo) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$url = ((DBFilePojoRealmProxyInterface) object).realmGet$url();
            if (realmGet$url != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.urlIndex, rowIndex, realmGet$url, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.urlIndex, rowIndex, false);
            }
            String realmGet$title = ((DBFilePojoRealmProxyInterface) object).realmGet$title();
            if (realmGet$title != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.titleIndex, rowIndex, false);
            }
        }
    }

    public static com.example.vadim.photobyword.pojo.DBFilePojo createDetachedCopy(com.example.vadim.photobyword.pojo.DBFilePojo realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.example.vadim.photobyword.pojo.DBFilePojo unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.example.vadim.photobyword.pojo.DBFilePojo();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.example.vadim.photobyword.pojo.DBFilePojo) cachedObject.object;
            }
            unmanagedObject = (com.example.vadim.photobyword.pojo.DBFilePojo) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        DBFilePojoRealmProxyInterface unmanagedCopy = (DBFilePojoRealmProxyInterface) unmanagedObject;
        DBFilePojoRealmProxyInterface realmSource = (DBFilePojoRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$url(realmSource.realmGet$url());
        unmanagedCopy.realmSet$title(realmSource.realmGet$title());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("DBFilePojo = proxy[");
        stringBuilder.append("{url:");
        stringBuilder.append(realmGet$url() != null ? realmGet$url() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{title:");
        stringBuilder.append(realmGet$title() != null ? realmGet$title() : "null");
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DBFilePojoRealmProxy aDBFilePojo = (DBFilePojoRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aDBFilePojo.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aDBFilePojo.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aDBFilePojo.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
