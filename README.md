PillowStore
===========

Simple Key-Value/JSON store for Android

```java
JSONKeyValueStore store = new JSONKeyValueStore(this, "pillow.db"); //init store
JSONObject obj = new JSONObject().put("Hello", "World!");
store.put(KEY_TEST, obj); //put
store.getJSONObject(KEY_TEST); //get
store.close();
```
