/*
 *  Copyright (c) 2019 DCCS GmbH. All rights reserved.
 *  Implemented 2019 by DCCS GmbH.
 */

import * as React from 'react';
import * as styles from '../../themes/app.scss';

/**
 * User mapping. Equivalent to server side projection.
 */
interface UserProjection {
  id: number;
  firstName: string;
  lastName: string;
  departmentName: string;
  platName: string;
  email: string;
}

interface AppState {
  users?: UserProjection[];
}

/**
 * The component that displays the application.
 */
export class App extends React.PureComponent<{}, AppState> {
  constructor(props: {}) {
    super(props);
    this.state = {};

    this.fetchUsers();
  }

  render() {
    const { users = [] } = this.state;

    return (
      <React.Fragment>
        <div className={styles.someClass}>
          <p>Hello react 123!!!</p>
        </div>
        <div>{this.renderUserTable(users)}</div>
      </React.Fragment>
    );
  }

  private fetchUsers() {
    const request = fetch('/rest/users', {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json'
      }
    });

    request.then((response: Response) => {
      if (response.ok) {
        response.json().then((data: UserProjection[]) =>
          this.setState({
            users: data
          })
        );
      } else {
        console.log('Request failed with following reasons ', response.status, response.statusText);
      }
    });
  }

  private renderUserTable(users: UserProjection[]) {
    const body = users.length
      ? users.map((user: UserProjection) => this.renderUser(user))
      : this.renderNoDataContainer();

    return (
      <table>
        <thead>
          <tr>
            <th>First name</th>
            <th>Last name</th>
            <th>Email</th>
            <th>Department</th>
            <th>Plant</th>
          </tr>
        </thead>
        <tbody>{body}</tbody>
      </table>
    );
  }

  private renderUser(user: UserProjection) {
    return (
      <tr key={user.id}>
        <td>{user.firstName}</td>
        <td>{user.lastName}</td>
        <td>{user.email}</td>
        <td>{user.departmentName}</td>
        <td>{user.platName}</td>
      </tr>
    );
  }

  private renderNoDataContainer() {
    return (
      <tr>
        <td colSpan={5} align="center">
          No users were found in the table
        </td>
      </tr>
    );
  }
}
