PillowStore
===========

Simple Key-Value/JSON store for Android

```java
JSONKeyValueStore store = new JSONKeyValueStore(this, "pillow.db");
JSONObject obj = new JSONObject().put("Hello", "World!");
store.put(KEY_TEST, obj);
store.getJSONObject(KEY_TEST);
store.close();
```
