import { BrowserRouter, Routes, Route, Link } from 'react-router-dom';
import Login from './pages/Login'
import Groups from './pages/Groups'

export default function App() {
  return (
      <BrowserRouter>
        <nav>
          <ul>
            <li><Link to="/">Login</Link></li>
            <li><Link to="/groups">Groups</Link></li>
          </ul>
        </nav>
        <Routes>
          <Route path="/" element={Login}/>
          <Route path="/" element={Groups}/>
        </Routes>
      </BrowserRouter>
  )
}

