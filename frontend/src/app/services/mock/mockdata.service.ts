import { Injectable } from '@angular/core';
import { City } from 'src/app/models/city';
import { Media } from "../../models/media";
import { Content } from "../../models/content";
import {User} from "../../models/user";
import {Point} from "../../models/point";
import {ContentStatus} from "../../models/contentstatus";

@Injectable({
	providedIn: 'root'
})
export class MockdataService {

	public static getCityMocks() : City[] {
		return [
			{ id: 1, cadastralCode: "ABC123", name: "Porto San Giorgio", region: "Marche", province: "FM", istatCode: "12345", longitude: 43.180144, latitude: 13.793122, points: [], contests: []},
			{ id: 2, cadastralCode: "DEF456", name: "Camerino", region: "Marche", province: "MC", istatCode: "67890", longitude: 43.135702, latitude: 13.068382, points: [this.getPointMock()], contests: [] },
			{ id: 3, cadastralCode: "GHI789", name: "Senigallia", region: "Marche", province: "AN", istatCode: "98765", longitude: 43.719696, latitude: 13.215435, points: [], contests: [] }
		]
	}

	public static getCityMock(id: number) : City | undefined {
		return this.getCityMocks().find(c => c.id == id);
	}

	public static getMediaMock() : Media {
		return { id: 1, name: "sottocorte", path: "https://www.unicam.it/sites/default/files/eventi/2021/10/loc/scuola_Urbani_10marzo2021.jpeg" }
	}

	public static getContentStatus() : ContentStatus{
		return <ContentStatus>"Pending";
	}
	public static getUserMock() : User {
		return {id: 1, email: "johndoe@gmail.com", name: "John", surname: "Doe", username: "JohnDoe", fiscalCode: "JDGWMJ87A23F364O", password: "-"}
	}

	public static getPointMock() : Point {
		return { id: 1, name: "CHIP", longitude: 43.141148, latitude: 13.069556, imageUrl:"https://media.licdn.com/dms/image/C4D1BAQGwCjmEyT3SeQ/company-background_10000/0/1647002794380/chip_unicam_cover?e=2147483647&v=beta&t=zeFwzvOmhAjJhPUMuYTfpuD8YXbbvHQukE5z3aKfxH8", description: "chipi chipi chapa chapa dubi dubi daba daba", city: { id: 2, cadastralCode: "DEF456", name: "Camerino", region: "Marche", province: "MC", istatCode: "67890", longitude: 43.135702, latitude: 13.068382, points: [], contests: [] }, contents: []}
	}

	public static getContentMock() : Content {
		return { id: 1, title: "Convegno di astrofisica", description: "Quis eiusmod enim commodo quis incididunt labore ipsum pariatur irure. Esse ipsum magna ut irure Lorem ea enim do fugiat labore enim reprehenderit et tempor. Nisi et incididunt irure voluptate. Occaecat quis in ut est fugiat pariatur veniam ad dolor amet. Sunt esse elit reprehenderit sunt qui cillum. Pariatur Lorem magna adipisicing mollit aute. Ad non laboris ea.", author: this.getUserMock(), publicationDate: new Date("2023-02-10 15:45:00"), point: this.getPointMock(), media: this.getMediaMock(), status: this.getContentStatus()}
	}

}
