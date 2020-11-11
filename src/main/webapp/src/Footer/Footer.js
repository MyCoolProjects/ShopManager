import React, { Component } from 'react';
import { Container, Row, Col, Image, Nav, Button } from 'react-bootstrap';
import { Link } from 'react-router-dom';
import westCoast1 from '../westCoastImg/WestCoastShortText.jpg';
import westCoast2 from '../westCoastImg/WestCoastLogo.jpg';
import instagram from '../westCoastImg/instagram.png';
import vk from '../westCoastImg/vk.png';
import twitter from '../westCoastImg/twitter.png';
import facebook from '../westCoastImg/facebook.png';
import './Footer.css';
export default class Header extends Component {
    render() {
        return (
            <>
                <Container fluid className="footer">
                    <Container>
                        <Row>
                            <Col sm>
                                <Image fluid src={westCoast1} alt="WestCoast" width="30%" className="p-0 ml-0 mr-0 mt-3 mb-3" />
                            </Col>
                        </Row>
                        <hr className="footer-delimiters" color="white" />
                        <Row className="pt-2 pb-2">
                            <Col sm>
                                <div className="footer-text-disable-title"><b>Покупателям</b></div>
                                <Nav className="flex-column p-0 m-0">
                                    <Link className="footer-link" to="/">Домой</Link>
                                    <Link className="footer-link mt-2" to="/catalog">Каталог</Link>
                                </Nav>
                            </Col>
                            <Col sm style={{ textAlignLast: 'end' }}>
                                <div className="footer-text-disable-title"><b>Контакты</b></div>
                                <div className="footer-text-disable">г. Москва, Проспект Вернадского, д. 78</div>
                                <div className="footer-text-disable mt-2 mb-2">+7-495-666-69-69</div>
                                <Button variant="secondary">Обратная связь</Button>
                            </Col>

                        </Row>
                        <hr className="footer-delimiters" color="white" />

                        <Row className="pt-2 pb-2">
                            <Col sm >
                                <div className="footer-text-disable-title"><b>West Coast в соцсетях</b></div>
                                <div className="p-0 m-0" >
                                    <a className="p-0 m-0" href="https://ru-ru.facebook.com/mireaofficial/">
                                        <Image roundedCircle style={{ width: 40 }} src={facebook} alt="facebook" />
                                    </a>
                                    <a className="p-0 m-0" href="https://twitter.com/mirea_ru?ref_src=twsrc%5Egoogle%7Ctwcamp%5Eserp%7Ctwgr%5Eauthor">
                                        <Image roundedCircle style={{ width: 40, marginLeft: 30 }} src={twitter} alt="twitter" />
                                    </a>
                                    <a className="p-0 m-0" href="https://www.instagram.com/rtu_university_official/">
                                        <Image rounded style={{ width: 46, marginLeft: 30 }} src={instagram} alt="instagram" />
                                    </a>
                                    <a className="p-0 m-0" href="https://vk.com/mirea_official">
                                        <Image roundedCircle style={{ width: 40, marginLeft: 30 }} src={vk} alt="vk" />
                                    </a>

                                </div>
                            </Col>
                            <Col sm={5}>
                                <Image fluid src={westCoast2} alt="WestCoast" className="p-0 m-0" />
                            </Col>
                        </Row>
                        <hr className="footer-delimiters" color="white" />
                        <Row className="pt-2 pb-4">
                            <Col>
                                <div className="footer-text-disable">© «West Coast», 2020</div>
                            </Col>
                        </Row>
                    </Container>
                </Container>
            </>
        );
    }
}
