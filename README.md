# SSE Spring Boot Demo

Small [sse-eventbus](https://github.com/ralscha/sse-eventbus) demo using Spring Boot.

The application publishes server-sent events every five seconds and includes a small browser client served by Spring Boot.

## Requirements

- Java 25 or newer
- Maven Wrapper included in this repository

## Run

```bash
./mvnw spring-boot:run
```

On Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

## Browser Client

After the application starts, open:

```text
http://localhost:8080/
```

The page lets you enter a client id, connect to the backend, disconnect, and view the two event streams published by the demo.

## SSE Endpoint

The browser client connects to this endpoint:

```text
GET http://localhost:8080/register/{id}
```

`{id}` is the client id used by `sse-eventbus`.

The endpoint subscribes the client to these events:

- `message`: JSON array with five random integers from 0 to 30
- `dto`: JSON object, currently `{"i":10,"s":"test"}`

The first events are published after an initial two-second delay. New events are published every five seconds after that.

## Custom Client Example

```javascript
const source = new EventSource("http://localhost:8080/register/demo-client");

source.onmessage = event => {
  console.log("message", JSON.parse(event.data));
};

source.addEventListener("dto", event => {
  console.log("dto", JSON.parse(event.data));
});
```
