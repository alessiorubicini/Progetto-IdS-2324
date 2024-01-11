import {websocketConfig} from "./websocket.config";
import {WebSocketService} from "./web-socket.service";

export function WebSocketServiceFactory() {
	const rxStomp = new WebSocketService();
	rxStomp.configure(websocketConfig);
	rxStomp.activate();
	return rxStomp;
}
