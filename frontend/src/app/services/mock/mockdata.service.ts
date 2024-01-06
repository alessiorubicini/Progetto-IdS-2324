import { Injectable } from '@angular/core';
import { City } from 'src/app/models/city';
import { Content } from "../../models/content";
import {User} from "../../models/user";
import {Point} from "../../models/point";
import {ContentStatus} from "../../models/contentstatus";
import {UserInfo} from "../../models/user-info";
import { Contest } from 'src/app/models/contest';

@Injectable({
	providedIn: 'root'
})
export class MockdataService {
	
	
	public static getAllContestsMocks(): Contest[] {
		return [
			{ id: 1, title: "Christmas Market", description: "The market takes place on Thursday", publicationDate: new Date("2023-12-15 15:00:00"), closingDate: new Date("2023-12-20 20:00:00"), authorId:1, cityId:2, winnerId:3 },
			{ id: 2, title: "Summer Jamboree", description: "The hottest rockin' holiday on earth", publicationDate: new Date("2023-07-26 11:00:00"), closingDate:new Date("2023-08-14 18:00:00"), authorId:3, cityId:1, winnerId:1 }
		]
	}
	
	public static getContestMock(id: number) : Contest | undefined {
		return this.getAllContestsMocks().find(p => p.id == id);
	}


	public static getAllUsersMocks() : UserInfo[] {
		return [
			{ id: 1, email: "johndoe@gmail.com", name: "John", surname: "Doe", username: "JohnDoe", fiscalCode: "JDGWMJ87A23F364O", roles: [] },
			{ id: 2, email: "simone@gmail.com", name: "Simone", surname: "Morello", username: "Simon_Morel", fiscalCode: "SMMRWMJ87A23F364O", roles: []}
		]
	}

	public static getUserMock(id: number) : UserInfo | undefined {
		return this.getAllUsersMocks().find(u => u.id == id);
	}

	public static getAllCityMocks() : City[] {
		return [
			{ id: 1, cadastralCode: "ABC123", name: "Porto San Giorgio", region: "Marche", province: "FM", istatCode: "12345", longitude: 43.180144, latitude: 13.793122},
			{ id: 2, cadastralCode: "DEF456", name: "Camerino", region: "Marche", province: "MC", istatCode: "67890", longitude: 43.135702, latitude: 13.068382 },
			{ id: 3, cadastralCode: "GHI789", name: "Senigallia", region: "Marche", province: "AN", istatCode: "98765", longitude: 43.719696, latitude: 13.215435}
		]
	}

	public static getCityMock(id: number) : City | undefined {
		return this.getAllCityMocks().find(c => c.id == id);
	}

	public static getAllPointsMocks() : Point[] {
		return [
			{ id: 1, name: "Mobility", description: "Unlock seamless urban mobility in our city—effortless travel, efficient transportation, and interconnected pathways for a vibrant city life. 🏙️🚗 #SmartCity", imageUrl: "https://geospatialmedia.s3.amazonaws.com/wp-content/uploads/2019/05/smart-transportation-smart-city.png", cityId: 2 },
			{ id: 2, name: "Gastronomy", description: "Savor the city's culinary delights in the vibrant Gastronomy district – a haven of diverse flavors and gastronomic experiences. Bon appétit!", imageUrl: "https://mir-s3-cdn-cf.behance.net/project_modules/max_1200/36b45454981539.59714c1191971.png", cityId: 2 },
			{ id: 3, name: "Sport", description: "Discover the heart of our city's sports scene – a vibrant hub for enthusiasts, featuring top-notch facilities and exciting events. #CitySports", imageUrl: "https://img.freepik.com/free-vector/national-sports-day-illustration_23-2148993654.jpg?size=626&ext=jpg&ga=GA1.1.1546980028.1704326400&semt=ais", cityId: 2 },
			{ id: 4, name: "History", description: "Dive into the past of our city! Uncover its rich history, from ancient origins to modern milestones. Walk the footsteps of time", imageUrl: "https://media.istockphoto.com/id/1092170968/vector/open-book-with-history-doodles-and-lettering.jpg?s=612x612&w=0&k=20&c=SvXn0O25eHC8ARjwlcn83kahxjMGl2ti_DDFGozBKqg=", cityId: 2 },
			{ id: 5, name: "Sport", description: "Explore enchanting landmarks, vibrant culture, and hidden gems in our city's Tourism hub. Unforgettable experiences await!", imageUrl: "https://st4.depositphotos.com/16470190/25651/v/450/depositphotos_256510820-stock-illustration-planning-travel-with-online-services.jpg", cityId: 2 },
			{ id: 6, name: "ChIP", longitude: 43.141148, latitude: 13.069556, altitude: 661, imageUrl:"https://media.licdn.com/dms/image/C4D1BAQGwCjmEyT3SeQ/company-background_10000/0/1647002794380/chip_unicam_cover?e=2147483647&v=beta&t=zeFwzvOmhAjJhPUMuYTfpuD8YXbbvHQukE5z3aKfxH8", description: "The Chemistry Interdisciplinary Project (ChIP) is a new research center at the University of Camerino. The center’s design is inspired by the shape of an integrated circuit chip and is constructed using innovative techniques to ensure safety in the event of an earthquake.", cityId: 2}
		]
	}

	public static getAllPointMocksOfCity(id: number) : Point[] | undefined {
		return this.getAllPointsMocks().filter(p => p.cityId == id);
	}

	public static getPointMock(id: number) : Point | undefined {
		return this.getAllPointsMocks().find(p => p.id == id);
	}

	public static getContentMock() : Content {
		return { id: 1, title: "Convegno di astrofisica", description: "Unisciti a noi per esplorare le meraviglie dell'universo al nostro prossimo convegno di astrofisica! Esperti di fama mondiale condivideranno le ultime scoperte e teorie affascinanti nel campo dell'astrofisica, spaziando dall'origine dell'universo alle più recenti rivelazioni sui buchi neri e sulle galassie lontane.", authorId: 1, publicationDate: new Date("2023-02-10 15:45:00"), pointId: 6, mediaUrl: "https://www.unicam.it/sites/default/files/eventi/2021/10/loc/scuola_Urbani_10marzo2021.jpeg", status: this.getContentStatus()}
	}

	public static getAllContentsMocks(): Content[] {
		return [
			{ id: 1, title: "Convegno di astrofisica", description: "Unisciti a noi per esplorare le meraviglie dell'universo al nostro prossimo convegno di astrofisica! Esperti di fama mondiale condivideranno le ultime scoperte e teorie affascinanti nel campo dell'astrofisica, spaziando dall'origine dell'universo alle più recenti rivelazioni sui buchi neri e sulle galassie lontane.", authorId: 1, publicationDate: new Date("2023-02-10 15:45:00"), pointId: 6, mediaUrl: "https://www.unicam.it/sites/default/files/eventi/2021/10/loc/scuola_Urbani_10marzo2021.jpeg", status: this.getContentStatus()}
		]
	}

	public static getContentsMocksOfPoint(id: number) {
		return this.getAllContentsMocks().filter(c => c.pointId == id)!
	}

	public static getContentStatus() : ContentStatus{
		return <ContentStatus>"Pending";
	}
}
