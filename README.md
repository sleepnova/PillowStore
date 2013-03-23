PillowStore
===========

Simple Key-Value/JSON store for Android

```java
JSONKeyValueStore store = new JSONKeyValueStore(ctx, "pillow.db");
JSONObject obj = new JSONObject().put("Hello", "World!");
store.put("/key", obj);
store.getJSONObject("/key");
store.close();
```
