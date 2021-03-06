import { Body } from './components/body';
import { Header } from './components/header';
import Footer from './components/footer';
import axios from 'axios';

function App() {
  return (
    <div className="App">
      <Header />
      <Body />
      <Footer />
    </div>
  );
}

export default App;
