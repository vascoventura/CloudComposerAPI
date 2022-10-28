/*
 * Airflow API (Stable)
 * # Overview  To facilitate management, Apache Airflow supports a range of REST API endpoints across its objects. This section provides an overview of the API design, methods, and supported use cases.  Most of the endpoints accept `JSON` as input and return `JSON` responses. This means that you must usually add the following headers to your request: ``` Content-type: application/json Accept: application/json ```  ## Resources  The term `resource` refers to a single type of object in the Airflow metadata. An API is broken up by its endpoint's corresponding resource. The name of a resource is typically plural and expressed in camelCase. Example: `dagRuns`.  Resource names are used as part of endpoint URLs, as well as in API parameters and responses.  ## CRUD Operations  The platform supports **C**reate, **R**ead, **U**pdate, and **D**elete operations on most resources. You can review the standards for these operations and their standard parameters below.  Some endpoints have special behavior as exceptions.  ### Create  To create a resource, you typically submit an HTTP `POST` request with the resource's required metadata in the request body. The response returns a `201 Created` response code upon success with the resource's metadata, including its internal `id`, in the response body.  ### Read  The HTTP `GET` request can be used to read a resource or to list a number of resources.  A resource's `id` can be submitted in the request parameters to read a specific resource. The response usually returns a `200 OK` response code upon success, with the resource's metadata in the response body.  If a `GET` request does not include a specific resource `id`, it is treated as a list request. The response usually returns a `200 OK` response code upon success, with an object containing a list of resources' metadata in the response body.  When reading resources, some common query parameters are usually available. e.g.: ``` v1/connections?limit=25&offset=25 ```  |Query Parameter|Type|Description| |---------------|----|-----------| |limit|integer|Maximum number of objects to fetch. Usually 25 by default| |offset|integer|Offset after which to start returning objects. For use with limit query parameter.|  ### Update  Updating a resource requires the resource `id`, and is typically done using an HTTP `PATCH` request, with the fields to modify in the request body. The response usually returns a `200 OK` response code upon success, with information about the modified resource in the response body.  ### Delete  Deleting a resource requires the resource `id` and is typically executing via an HTTP `DELETE` request. The response usually returns a `204 No Content` response code upon success.  ## Conventions  - Resource names are plural and expressed in camelCase. - Names are consistent between URL parameter name and field name.  - Field names are in snake_case. ```json {     \"name\": \"string\",     \"slots\": 0,     \"occupied_slots\": 0,     \"used_slots\": 0,     \"queued_slots\": 0,     \"open_slots\": 0 } ```  ### Update Mask  Update mask is available as a query parameter in patch endpoints. It is used to notify the API which fields you want to update. Using `update_mask` makes it easier to update objects by helping the server know which fields to update in an object instead of updating all fields. The update request ignores any fields that aren't specified in the field mask, leaving them with their current values.  Example: ```   resource = request.get('/resource/my-id').json()   resource['my_field'] = 'new-value'   request.patch('/resource/my-id?update_mask=my_field', data=json.dumps(resource)) ```  ## Versioning and Endpoint Lifecycle  - API versioning is not synchronized to specific releases of the Apache Airflow. - APIs are designed to be backward compatible. - Any changes to the API will first go through a deprecation phase.  # Trying the API  You can use a third party client, such as [curl](https://curl.haxx.se/), [HTTPie](https://httpie.org/), [Postman](https://www.postman.com/) or [the Insomnia rest client](https://insomnia.rest/) to test the Apache Airflow API.  Note that you will need to pass credentials data.  For e.g., here is how to pause a DAG with [curl](https://curl.haxx.se/), when basic authorization is used: ```bash curl -X PATCH 'https://example.com/api/v1/dags/{dag_id}?update_mask=is_paused' \\ -H 'Content-Type: application/json' \\ --user \"username:password\" \\ -d '{     \"is_paused\": true }' ```  Using a graphical tool such as [Postman](https://www.postman.com/) or [Insomnia](https://insomnia.rest/), it is possible to import the API specifications directly:  1. Download the API specification by clicking the **Download** button at top of this document 2. Import the JSON specification in the graphical tool of your choice.   - In *Postman*, you can click the **import** button at the top   - With *Insomnia*, you can just drag-and-drop the file on the UI  Note that with *Postman*, you can also generate code snippets by selecting a request and clicking on the **Code** button.  ## Enabling CORS  [Cross-origin resource sharing (CORS)](https://developer.mozilla.org/en-US/docs/Web/HTTP/CORS) is a browser security feature that restricts HTTP requests that are initiated from scripts running in the browser.  For details on enabling/configuring CORS, see [Enabling CORS](https://airflow.apache.org/docs/apache-airflow/stable/security/api.html).  # Authentication  To be able to meet the requirements of many organizations, Airflow supports many authentication methods, and it is even possible to add your own method.  If you want to check which auth backend is currently set, you can use `airflow config get-value api auth_backends` command as in the example below. ```bash $ airflow config get-value api auth_backends airflow.api.auth.backend.basic_auth ``` The default is to deny all requests.  For details on configuring the authentication, see [API Authorization](https://airflow.apache.org/docs/apache-airflow/stable/security/api.html).  # Errors  We follow the error response format proposed in [RFC 7807](https://tools.ietf.org/html/rfc7807) also known as Problem Details for HTTP APIs. As with our normal API responses, your client must be prepared to gracefully handle additional members of the response.  ## Unauthenticated  This indicates that the request has not been applied because it lacks valid authentication credentials for the target resource. Please check that you have valid credentials.  ## PermissionDenied  This response means that the server understood the request but refuses to authorize it because it lacks sufficient rights to the resource. It happens when you do not have the necessary permission to execute the action you performed. You need to get the appropriate permissions in other to resolve this error.  ## BadRequest  This response means that the server cannot or will not process the request due to something that is perceived to be a client error (e.g., malformed request syntax, invalid request message framing, or deceptive request routing). To resolve this, please ensure that your syntax is correct.  ## NotFound  This client error response indicates that the server cannot find the requested resource.  ## MethodNotAllowed  Indicates that the request method is known by the server but is not supported by the target resource.  ## NotAcceptable  The target resource does not have a current representation that would be acceptable to the user agent, according to the proactive negotiation header fields received in the request, and the server is unwilling to supply a default representation.  ## AlreadyExists  The request could not be completed due to a conflict with the current state of the target resource, e.g. the resource it tries to create already exists.  ## Unknown  This means that the server encountered an unexpected condition that prevented it from fulfilling the request. 
 *
 * OpenAPI spec version: 2.3.0
 * Contact: dev@airflow.apache.org
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package io.swagger.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.gsonfire.GsonFireBuilder;
import io.gsonfire.PostProcessor;
import io.gsonfire.TypeSelector;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.bind.util.ISO8601Utils;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import org.threeten.bp.LocalDate;
import org.threeten.bp.OffsetDateTime;
import org.threeten.bp.format.DateTimeFormatter;

import io.swagger.client.model.*;

import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;

public class JSON {
    private Gson gson;
    private boolean isLenientOnJson = false;
    private DateTypeAdapter dateTypeAdapter = new DateTypeAdapter();
    private SqlDateTypeAdapter sqlDateTypeAdapter = new SqlDateTypeAdapter();
    private OffsetDateTimeTypeAdapter offsetDateTimeTypeAdapter = new OffsetDateTimeTypeAdapter();
    private LocalDateTypeAdapter localDateTypeAdapter = new LocalDateTypeAdapter();

    public static GsonBuilder createGson() {
        GsonFireBuilder fireBuilder = new GsonFireBuilder()
          .registerTypeSelector(ConnectionCollectionItem.class, new TypeSelector<ConnectionCollectionItem>() {
            @Override
            public Class<? extends ConnectionCollectionItem> getClassForElement(JsonElement readElement) {
                Map<String, Class<? extends ConnectionCollectionItem>> classByDiscriminatorValue = new HashMap<>();
                    classByDiscriminatorValue.put("Connection".toUpperCase(), Connection.class);
                    classByDiscriminatorValue.put("ConnectionCollectionItem".toUpperCase(), ConnectionCollectionItem.class);
                return getClassByDiscriminator(
                            classByDiscriminatorValue,
                            getDiscriminatorValue(readElement, ""));
            }
          })
          .registerPostProcessor(ConnectionCollectionItem.class, new PostProcessor<ConnectionCollectionItem>() {
              @Override
              public void postDeserialize(ConnectionCollectionItem result, JsonElement src, Gson gson) {

              }

              @Override
              public void postSerialize(JsonElement result, ConnectionCollectionItem src, Gson gson) {
                  Map<Class<? extends ConnectionCollectionItem>, String> discriminatorValueByClass = new HashMap<>();
                      discriminatorValueByClass.put(Connection.class, "Connection");
                      discriminatorValueByClass.put(ConnectionCollectionItem.class, "ConnectionCollectionItem");
                  if(result instanceof JsonObject)
                  {
                      if(!((JsonObject) result).has(""))
                      {
                          ((JsonObject) result).addProperty("", discriminatorValueByClass.get(src.getClass()));
                      }
                  }
              }
          })
          .registerTypeSelector(DAG.class, new TypeSelector<DAG>() {
            @Override
            public Class<? extends DAG> getClassForElement(JsonElement readElement) {
                Map<String, Class<? extends DAG>> classByDiscriminatorValue = new HashMap<>();
                    classByDiscriminatorValue.put("DAGDetail".toUpperCase(), DAGDetail.class);
                    classByDiscriminatorValue.put("DAG".toUpperCase(), DAG.class);
                return getClassByDiscriminator(
                            classByDiscriminatorValue,
                            getDiscriminatorValue(readElement, ""));
            }
          })
          .registerPostProcessor(DAG.class, new PostProcessor<DAG>() {
              @Override
              public void postDeserialize(DAG result, JsonElement src, Gson gson) {

              }

              @Override
              public void postSerialize(JsonElement result, DAG src, Gson gson) {
                  Map<Class<? extends DAG>, String> discriminatorValueByClass = new HashMap<>();
                      discriminatorValueByClass.put(DAGDetail.class, "DAGDetail");
                      discriminatorValueByClass.put(DAG.class, "DAG");
                  if(result instanceof JsonObject)
                  {
                      if(!((JsonObject) result).has(""))
                      {
                          ((JsonObject) result).addProperty("", discriminatorValueByClass.get(src.getClass()));
                      }
                  }
              }
          })
          .registerTypeSelector(ProviderCollection.class, new TypeSelector<ProviderCollection>() {
            @Override
            public Class<? extends ProviderCollection> getClassForElement(JsonElement readElement) {
                Map<String, Class<? extends ProviderCollection>> classByDiscriminatorValue = new HashMap<>();
                    classByDiscriminatorValue.put("inline_response_200".toUpperCase(), InlineResponse200.class);
                    classByDiscriminatorValue.put("ProviderCollection".toUpperCase(), ProviderCollection.class);
                return getClassByDiscriminator(
                            classByDiscriminatorValue,
                            getDiscriminatorValue(readElement, ""));
            }
          })
          .registerPostProcessor(ProviderCollection.class, new PostProcessor<ProviderCollection>() {
              @Override
              public void postDeserialize(ProviderCollection result, JsonElement src, Gson gson) {

              }

              @Override
              public void postSerialize(JsonElement result, ProviderCollection src, Gson gson) {
                  Map<Class<? extends ProviderCollection>, String> discriminatorValueByClass = new HashMap<>();
                      discriminatorValueByClass.put(InlineResponse200.class, "inline_response_200");
                      discriminatorValueByClass.put(ProviderCollection.class, "ProviderCollection");
                  if(result instanceof JsonObject)
                  {
                      if(!((JsonObject) result).has(""))
                      {
                          ((JsonObject) result).addProperty("", discriminatorValueByClass.get(src.getClass()));
                      }
                  }
              }
          })
          .registerTypeSelector(UserCollectionItem.class, new TypeSelector<UserCollectionItem>() {
            @Override
            public Class<? extends UserCollectionItem> getClassForElement(JsonElement readElement) {
                Map<String, Class<? extends UserCollectionItem>> classByDiscriminatorValue = new HashMap<>();
                    classByDiscriminatorValue.put("User".toUpperCase(), User.class);
                    classByDiscriminatorValue.put("UserCollectionItem".toUpperCase(), UserCollectionItem.class);
                return getClassByDiscriminator(
                            classByDiscriminatorValue,
                            getDiscriminatorValue(readElement, ""));
            }
          })
          .registerPostProcessor(UserCollectionItem.class, new PostProcessor<UserCollectionItem>() {
              @Override
              public void postDeserialize(UserCollectionItem result, JsonElement src, Gson gson) {

              }

              @Override
              public void postSerialize(JsonElement result, UserCollectionItem src, Gson gson) {
                  Map<Class<? extends UserCollectionItem>, String> discriminatorValueByClass = new HashMap<>();
                      discriminatorValueByClass.put(User.class, "User");
                      discriminatorValueByClass.put(UserCollectionItem.class, "UserCollectionItem");
                  if(result instanceof JsonObject)
                  {
                      if(!((JsonObject) result).has(""))
                      {
                          ((JsonObject) result).addProperty("", discriminatorValueByClass.get(src.getClass()));
                      }
                  }
              }
          })
          .registerTypeSelector(VariableCollectionItem.class, new TypeSelector<VariableCollectionItem>() {
            @Override
            public Class<? extends VariableCollectionItem> getClassForElement(JsonElement readElement) {
                Map<String, Class<? extends VariableCollectionItem>> classByDiscriminatorValue = new HashMap<>();
                    classByDiscriminatorValue.put("Variable".toUpperCase(), Variable.class);
                    classByDiscriminatorValue.put("VariableCollectionItem".toUpperCase(), VariableCollectionItem.class);
                return getClassByDiscriminator(
                            classByDiscriminatorValue,
                            getDiscriminatorValue(readElement, ""));
            }
          })
          .registerPostProcessor(VariableCollectionItem.class, new PostProcessor<VariableCollectionItem>() {
              @Override
              public void postDeserialize(VariableCollectionItem result, JsonElement src, Gson gson) {

              }

              @Override
              public void postSerialize(JsonElement result, VariableCollectionItem src, Gson gson) {
                  Map<Class<? extends VariableCollectionItem>, String> discriminatorValueByClass = new HashMap<>();
                      discriminatorValueByClass.put(Variable.class, "Variable");
                      discriminatorValueByClass.put(VariableCollectionItem.class, "VariableCollectionItem");
                  if(result instanceof JsonObject)
                  {
                      if(!((JsonObject) result).has(""))
                      {
                          ((JsonObject) result).addProperty("", discriminatorValueByClass.get(src.getClass()));
                      }
                  }
              }
          })
          .registerTypeSelector(XComCollectionItem.class, new TypeSelector<XComCollectionItem>() {
            @Override
            public Class<? extends XComCollectionItem> getClassForElement(JsonElement readElement) {
                Map<String, Class<? extends XComCollectionItem>> classByDiscriminatorValue = new HashMap<>();
                    classByDiscriminatorValue.put("XCom".toUpperCase(), XCom.class);
                    classByDiscriminatorValue.put("XComCollectionItem".toUpperCase(), XComCollectionItem.class);
                return getClassByDiscriminator(
                            classByDiscriminatorValue,
                            getDiscriminatorValue(readElement, ""));
            }
          })
          .registerPostProcessor(XComCollectionItem.class, new PostProcessor<XComCollectionItem>() {
              @Override
              public void postDeserialize(XComCollectionItem result, JsonElement src, Gson gson) {

              }

              @Override
              public void postSerialize(JsonElement result, XComCollectionItem src, Gson gson) {
                  Map<Class<? extends XComCollectionItem>, String> discriminatorValueByClass = new HashMap<>();
                      discriminatorValueByClass.put(XCom.class, "XCom");
                      discriminatorValueByClass.put(XComCollectionItem.class, "XComCollectionItem");
                  if(result instanceof JsonObject)
                  {
                      if(!((JsonObject) result).has(""))
                      {
                          ((JsonObject) result).addProperty("", discriminatorValueByClass.get(src.getClass()));
                      }
                  }
              }
          })
        ;
        return fireBuilder.createGsonBuilder();
    }

    private static String getDiscriminatorValue(JsonElement readElement, String discriminatorField) {
        JsonElement element = readElement.getAsJsonObject().get(discriminatorField);
        if(null == element) {
            throw new IllegalArgumentException("missing discriminator field: <" + discriminatorField + ">");
        }
        return element.getAsString();
    }

    private static <T> Class<? extends T> getClassByDiscriminator(Map<String, Class<? extends T>> classByDiscriminatorValue, String discriminatorValue) {
        Class<? extends T> clazz = classByDiscriminatorValue.get(discriminatorValue.toUpperCase());
        if(null == clazz) {
            throw new IllegalArgumentException("cannot determine model class of name: <" + discriminatorValue + ">");
        }
        return clazz;
    }

    public JSON() {
        gson = createGson()
            .registerTypeAdapter(Date.class, dateTypeAdapter)
            .registerTypeAdapter(java.sql.Date.class, sqlDateTypeAdapter)
            .registerTypeAdapter(OffsetDateTime.class, offsetDateTimeTypeAdapter)
            .registerTypeAdapter(LocalDate.class, localDateTypeAdapter)
            .create();
    }

    /**
     * Get Gson.
     *
     * @return Gson
     */
    public Gson getGson() {
        return gson;
    }

    /**
     * Set Gson.
     *
     * @param gson Gson
     * @return JSON
     */
    public JSON setGson(Gson gson) {
        this.gson = gson;
        return this;
    }

    public JSON setLenientOnJson(boolean lenientOnJson) {
        isLenientOnJson = lenientOnJson;
        return this;
    }

    /**
     * Serialize the given Java object into JSON string.
     *
     * @param obj Object
     * @return String representation of the JSON
     */
    public String serialize(Object obj) {
        return gson.toJson(obj);
    }

    /**
     * Deserialize the given JSON string to Java object.
     *
     * @param <T>        Type
     * @param body       The JSON string
     * @param returnType The type to deserialize into
     * @return The deserialized Java object
     */
    @SuppressWarnings("unchecked")
    public <T> T deserialize(String body, Type returnType) {
        try {
            if (isLenientOnJson) {
                JsonReader jsonReader = new JsonReader(new StringReader(body));
                // see https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/stream/JsonReader.html#setLenient(boolean)
                jsonReader.setLenient(true);
                return gson.fromJson(jsonReader, returnType);
            } else {
                return gson.fromJson(body, returnType);
            }
        } catch (JsonParseException e) {
            // Fallback processing when failed to parse JSON form response body:
            // return the response body string directly for the String return type;
            if (returnType.equals(String.class))
                return (T) body;
            else throw (e);
        }
    }

    /**
     * Gson TypeAdapter for JSR310 OffsetDateTime type
     */
    public static class OffsetDateTimeTypeAdapter extends TypeAdapter<OffsetDateTime> {

        private DateTimeFormatter formatter;

        public OffsetDateTimeTypeAdapter() {
            this(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        }

        public OffsetDateTimeTypeAdapter(DateTimeFormatter formatter) {
            this.formatter = formatter;
        }

        public void setFormat(DateTimeFormatter dateFormat) {
            this.formatter = dateFormat;
        }

        @Override
        public void write(JsonWriter out, OffsetDateTime date) throws IOException {
            if (date == null) {
                out.nullValue();
            } else {
                out.value(formatter.format(date));
            }
        }

        @Override
        public OffsetDateTime read(JsonReader in) throws IOException {
            switch (in.peek()) {
                case NULL:
                    in.nextNull();
                    return null;
                default:
                    String date = in.nextString();
                    if (date.endsWith("+0000")) {
                        date = date.substring(0, date.length()-5) + "Z";
                    }
                    return OffsetDateTime.parse(date, formatter);
            }
        }
    }

    /**
     * Gson TypeAdapter for JSR310 LocalDate type
     */
    public class LocalDateTypeAdapter extends TypeAdapter<LocalDate> {

        private DateTimeFormatter formatter;

        public LocalDateTypeAdapter() {
            this(DateTimeFormatter.ISO_LOCAL_DATE);
        }

        public LocalDateTypeAdapter(DateTimeFormatter formatter) {
            this.formatter = formatter;
        }

        public void setFormat(DateTimeFormatter dateFormat) {
            this.formatter = dateFormat;
        }

        @Override
        public void write(JsonWriter out, LocalDate date) throws IOException {
            if (date == null) {
                out.nullValue();
            } else {
                out.value(formatter.format(date));
            }
        }

        @Override
        public LocalDate read(JsonReader in) throws IOException {
            switch (in.peek()) {
                case NULL:
                    in.nextNull();
                    return null;
                default:
                    String date = in.nextString();
                    return LocalDate.parse(date, formatter);
            }
        }
    }

    public JSON setOffsetDateTimeFormat(DateTimeFormatter dateFormat) {
        offsetDateTimeTypeAdapter.setFormat(dateFormat);
        return this;
    }

    public JSON setLocalDateFormat(DateTimeFormatter dateFormat) {
        localDateTypeAdapter.setFormat(dateFormat);
        return this;
    }

    /**
     * Gson TypeAdapter for java.sql.Date type
     * If the dateFormat is null, a simple "yyyy-MM-dd" format will be used
     * (more efficient than SimpleDateFormat).
     */
    public static class SqlDateTypeAdapter extends TypeAdapter<java.sql.Date> {

        private DateFormat dateFormat;

        public SqlDateTypeAdapter() {
        }

        public SqlDateTypeAdapter(DateFormat dateFormat) {
            this.dateFormat = dateFormat;
        }

        public void setFormat(DateFormat dateFormat) {
            this.dateFormat = dateFormat;
        }

        @Override
        public void write(JsonWriter out, java.sql.Date date) throws IOException {
            if (date == null) {
                out.nullValue();
            } else {
                String value;
                if (dateFormat != null) {
                    value = dateFormat.format(date);
                } else {
                    value = date.toString();
                }
                out.value(value);
            }
        }

        @Override
        public java.sql.Date read(JsonReader in) throws IOException {
            switch (in.peek()) {
                case NULL:
                    in.nextNull();
                    return null;
                default:
                    String date = in.nextString();
                    try {
                        if (dateFormat != null) {
                            return new java.sql.Date(dateFormat.parse(date).getTime());
                        }
                        return new java.sql.Date(ISO8601Utils.parse(date, new ParsePosition(0)).getTime());
                    } catch (ParseException e) {
                        throw new JsonParseException(e);
                    }
            }
        }
    }

    /**
     * Gson TypeAdapter for java.util.Date type
     * If the dateFormat is null, ISO8601Utils will be used.
     */
    public static class DateTypeAdapter extends TypeAdapter<Date> {

        private DateFormat dateFormat;

        public DateTypeAdapter() {
        }

        public DateTypeAdapter(DateFormat dateFormat) {
            this.dateFormat = dateFormat;
        }

        public void setFormat(DateFormat dateFormat) {
            this.dateFormat = dateFormat;
        }

        @Override
        public void write(JsonWriter out, Date date) throws IOException {
            if (date == null) {
                out.nullValue();
            } else {
                String value;
                if (dateFormat != null) {
                    value = dateFormat.format(date);
                } else {
                    value = ISO8601Utils.format(date, true);
                }
                out.value(value);
            }
        }

        @Override
        public Date read(JsonReader in) throws IOException {
            try {
                switch (in.peek()) {
                    case NULL:
                        in.nextNull();
                        return null;
                    default:
                        String date = in.nextString();
                        try {
                            if (dateFormat != null) {
                                return dateFormat.parse(date);
                            }
                            return ISO8601Utils.parse(date, new ParsePosition(0));
                        } catch (ParseException e) {
                            throw new JsonParseException(e);
                        }
                }
            } catch (IllegalArgumentException e) {
                throw new JsonParseException(e);
            }
        }
    }

    public JSON setDateFormat(DateFormat dateFormat) {
        dateTypeAdapter.setFormat(dateFormat);
        return this;
    }

    public JSON setSqlDateFormat(DateFormat dateFormat) {
        sqlDateTypeAdapter.setFormat(dateFormat);
        return this;
    }

}
